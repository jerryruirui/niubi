$(function () {
	
	var columns = [
        { checkbox: true, align: 'center' },
      	{ title: '图片', field: 'picUrl',
			formatter: function (value, row, index) {
				return '<img width="80px" height="60px" src="'+value+'" />';
			}	
		}, 
		{ title: '景区名称', field: 'scenicName'},
		{ title: '分类', field: 'category.categoryName'},
		{ title: '价格', field: 'price'},
		{ title: '状态', field: 'status', formatter: function(value, row){
			if(value == 0){
				return '<span class="label label-default">已下架</span>';
			}else if(value == 1){
				return '<span class="label label-primary">出售中</span>';
			}
			return '';
		}},
		{ title: '创建时间', field: 'createTime'}
		];
	
	$("#table").bootstrapTable({
        url: baseURL + 'scenic/list',
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
	        	scenicName: vm.q.scenicName
        	}
        }
	});
	
});

var vm = new Vue({
	el:'#app',
	data:{
		showList: true,
		title: null,
		scenic: {
			picUrls: []
		},
		
		categoryList: [],
		q:{
			scenicName: ''
		}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		openMap: function(){
			layer.open({
                type: 2,
                title: '地图',
                shadeClose: true,
                shade: 0.8,
                area: ['600px', '600px'],
                btn: ['确定'],
                content: 'map.html', //iframe的url
                yes: function(index, content){
                  var body = layer.getChildFrame('body', index);
  				  var lat = body.find("#lat").val();
  				  var lng = body.find("#lng").val();
  				  debugger
  				  if(lat == ""){
  					  alert("请选择地址");
  					  return;
  				  }
  				  vm.scenic.lat = lat;
  				  vm.scenic.lng = lng;
  				  layer.close(index);
  			  }
            });
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.scenic = {
				picUrls: [],
				categoryId : "",
				scenicSpecList:[{
					specName: "儿童",
					price: ''
				},{
					specName: "成人",
					price: ''
				},{
					specName: "老人",
					price: ''
				}]
			};
		},
		update: function (event) {
			var id = getSelectedVal("id");
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            vm.scenic = {
    			picUrls: []
    		};
            
            vm.getInfo(id);
		},
		saveOrUpdate: function (event) {
			if(vm.validator()){
				return;
			}
			
			var url = vm.scenic.id == null ? "scenic/save" : "scenic/update";
			vm.scenic.picUrl = vm.scenic.picUrls[0];
			vm.scenic.describe = ue.getContent();
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.scenic),
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
				    url: baseURL + "scenic/delete",
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
		upper: function(){
			var ids = getSelectedVals("id");
			if(ids == null){
				return ;
			}
			confirm('确定要上架选中的记录？', function(){
			$.ajax({
				type: "POST",
			    url: baseURL + "scenic/upper",
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
		lower: function(){
			var ids = getSelectedVals("id");
			if(ids == null){
				return ;
			}
			confirm('确定要下架选中的记录？', function(){
			$.ajax({
				type: "POST",
			    url: baseURL + "scenic/lower",
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
			$.get(baseURL + "scenic/info/"+id, function(r){
                vm.scenic = r.scenic;
                ue.setContent(r.scenic.describe);
            });
		},
		getCategoryList: function(){
			$.get(baseURL + "category/getAll", function(r){
				vm.categoryList = r.categoryList;
			});
		},
		reload: function (event) {
			vm.showList = true;
			$('#table').bootstrapTable('refresh',  {pageNumber: 1});
		},
		validator: function () {
            if(vm.scenic.picUrls.length == 0){
                alert("请选择景区图片");
                return true;
            }

            if(isBlank(vm.scenic.scenicName)){
                alert("请填写景区名称");
                return true;
            }
            
            if(isBlank(vm.scenic.price)){
                alert("请填写价格");
                return true;
            }
        }
	},
	created: function(){
		this.getCategoryList();
	}
});