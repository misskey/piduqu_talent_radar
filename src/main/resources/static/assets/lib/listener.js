define([
	'jquery',
	'util',
	'colorbox'
],function($,sw_util){


	var sw_listener =  {

		/**
		 * 默认全局监听
		 */
		initDefaultListener: function() {

			$('body').on('click.tab.data-api', '[data-toggle="tab"], [data-toggle="pill"]', function (e) {
				e.preventDefault()
				$(this).tab('show')
			})

			//菜单监听
			$(document).on('click.[data-toggle="menu"]', 'a.accordion-toggle' ,function (e) {
				$(".md-accent-bg").removeClass("md-accent-bg");
				$(e.target).parents('.accordion-group').addClass("md-accent-bg");
				e.stopPropagation;
			})
			//下拉菜单 导航
			$(document).on('click.J_dropdown','li.J_dropdown',function (e) {
				$(".J_dropdown i").hide();
				$(e.target).find('i').show();
				$(".J_data").text($(e.target).text())
				if($(e.target).text()== "内部人才"){
					$.cookie(location.host + "_sou", 2, {expires: 365});
					location.reload();
				}else{
					$.cookie(location.host + "_sou", 1, {expires: 365});
					location.reload();
				}
				e.stopPropagation;
			})

			//弹框关闭
			$(document).on('click.J_cancel_dialog', '.J_cancel_dialog' ,function (e) {
				$.colorbox.close();
			})


			/*
			 * 多选框插件点击事件监听
			 */
			$(document).on("click.checkbox", "cite[type='checkbox']", function(event){
				sw_util.stopPop(event);
		/*		$(document).click();*/
				var me = $(event.target);
				if ( me.hasClass("disabled") )
				{
					return;
				}
				$(me.parent('.pos_item_Detail')).toggleClass('checkedBg');
				me.toggleClass("checked");
				event.stopPropagation();

			});


			//浏览器
			//$(window).bind('beforeunload',function(){$.cookie(location.host+"_userInfoResult","");});


			/*上传*/
			$(document).on("click.a", ".J_uploadExcel", function () {
				$.colorbox({
					inline:true,href:"#excelFileUpload_dialog",
					innerWidth:450,innerHeight:350,title:'上传简历录入',onComplete:function() {
						var button = $("#uploadExcel");
						button.change(function(){
							jTip('上传成功')
						})

					}
				});
			})
		},
		/**
		 * 窗口大小变更监听
		 */
		initResizeListener: function()
		{
			$(window).resize(function()
			{
				resize.window();
			});
			resize.window();
		},

		/**
		 * 自动较验监听
		 */
		initValidatorListener: function()
		{
			sw_validator.initAutoValidator();
		},


		/**
		 * 程序异常监听
		 * @ignore
		 */
		initErrorListerner: function()
		{

			window.onerror = function(msg, url, line){
				try
				{
					console.log(msg
					+ "\nurl:" + url
					+ "\nat line:" + line);
				}
				catch(e)
				{
					//
				}
				return true;
			};
		}
	};


	return sw_listener;

})
