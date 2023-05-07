$(function () {
	
	var columns = [
        { checkbox: true, align: 'center' },
		{ title: '订单编号', field: 'orderNumber', formatter: function(value, row){
			return "<a class='a-detail' onClick='vm.detail("+row.id+")'>"+value+"</a>";
		}},
		{ title: '用户', field: 'member.nickname'},
		{ title: '订单金额', field: 'totalAmount'},
		{ title: '订单状态', field: 'orderStatus', formatter: function(value, row){
			if(value == 0){
				return '<span class="label label-default">已取消</span>';
			}else if(value == 1){
				return '<span class="label label-primary">待付款</span>';
			}else if(value == 2){
				return '<span class="label label-success">已完成</span>';
			}
		}},
		{ title: '创建时间', field: 'createTime'}
		];
	
	$("#table").bootstrapTable({
        url: baseURL + 'order/list',
        cache: false,
        striped: true,
        pagination: true,
        pageSize: 10,
        pageNumber: 1,
        sidePagination: 'server',
        columns: columns,
        queryParams: function (params) {
        	return {
	        	page: params.offset / params.limit + 1,
	        	limit: params.limit,
	        	orderNumber: vm.q.orderNumber
        	}
        }
	});
	
});

var vm = new Vue({
	el:'#app',
	data:{
		showList: true,
		title: null,
		order: {
			orderShipment: {}
		},
		q: {
			orderNumber: ''
		}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.order = {};
		},
		update: function (event) {
			var id = getSelectedVal("id");
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
			var url = vm.order.id == null ? "order/save" : "order/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.order),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg, function(e){});
					}
				}
			});
		},
		del: function (event) {
			var ids = getSelectedVals("id");
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "order/delete",
                    contentType: "application/json",
				    data: JSON.stringify(ids),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								vm.reload();
							});
						}else{
							alert(r.msg, function(e){});
						}
					}
				});
			});
		},
		getInfo: function(id){
			$.get(baseURL + "order/info/"+id, function(r){
                vm.order = r.order;
            });
		},
		reload: function (event) {
			vm.showList = true;
			$('#table').bootstrapTable('refresh',  {pageNumber: 1});
		},
		detail: function(id){
			vm.showList = false;
			vm.title = "详情";
			vm.getInfo(id);
		},
		sendGoods: function(){
			var id = getSelectedVal("id");
			if(id == null){
				return ;
			}
			
			var html = '';

			html += '<div style="padding:10px">快递单号：<input name="courierNum" /></div>';

			layer.open({
			  type: 1,
			  shade: false,
			  content: html,
			  btn: ['确定'],
			  yes: function(index){
				  
				  var courierNum = $("input[name='courierNum']").val();
				  if(courierNum == ""){
					  alert("请填写快递单号");
					  return;
				  }
				  layer.close(index);
				  $.ajax({
						type: "POST",
					    url: baseURL + "order/sendGoods/" + id,
					    data: 'courierNum=' + courierNum,
					    success: function(r){
							if(r.code == 0){
								alert('操作成功', function(index){
									vm.reload();
								});
							}else{
								alert(r.msg, function(e){});
							}
						}
					});
			  }
			});
		}
	}
});