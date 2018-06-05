var document_title = document.title;

$(document).ready(function ()
{

    // fix form bug...
    // $("form[action='']").attr('action', window.location.href);

    // 验证码
    // $('img#captcha').attr('src', G_BASE_URL + '/account/captcha/');
    
    // 输入框自动增高
    // $('.autosize').autosize();

    //编辑器初始化
    // if (typeof Markdown != 'undefined' && $('#wmd-input').length)
    // {
    //     var converter1 = new Markdown.Converter();
    //
    //     var editor1 = new Markdown.Editor(converter1, $('.wmd-panel'), $('#wmd-preview'));
    //
    //     editor1.run();
    //
    //     AWS.Editor.set_editor_preview();
    //
    // }

    //响应式导航条效果
    $('.aw-top-nav .navbar-toggle').click(function()
    {
        if ($(this).parents('.aw-top-nav').find('.navbar-collapse').hasClass('active'))
        {
            $(this).parents('.aw-top-nav').find('.navbar-collapse').removeClass('active');
        }
        else
        {
            $(this).parents('.aw-top-nav').find('.navbar-collapse').addClass('active');
        }
    });
    //用户下拉显示
   var anav= $('.aw-user-nav');
   var alist= $('.aw-user-nav-dropdown-list');
    anav.mouseover(function () {
       alist.css("display","block")
    });

    anav.mouseout(function () {
        alist.css("display","none")
    });


    //提问题


    if (window.location.hash.indexOf('#!') != -1)
	{
		if ($('a[name=' + window.location.hash.replace('#!', '') + ']').length)
		{
			$.scrollTo($('a[name=' + window.location.hash.replace('#!', '') + ']').offset()['top'] - 20, 600, {queue:true});
		}
	}
	

    //ie浏览器下input,textarea兼容
    if (document.all)
    {
        AWS.check_placeholder($('input, textarea'));

        // 每隔1s轮询检测placeholder
        setInterval(function()
        {
            AWS.check_placeholder($('input[data-placeholder!="true"], textarea[data-placeholder!="true"]'));
        }, 1000);
    }
});

$(window).on('hashchange', function() {
    if (window.location.hash.indexOf('#!') != -1)
    {
        if ($('a[name=' + window.location.hash.replace('#!', '') + ']').length)
        {
            $.scrollTo($('a[name=' + window.location.hash.replace('#!', '') + ']').offset()['top'] - 20, 600, {queue:true});
        }
    }
});

$(window).scroll(function ()
{
    if ($('.aw-back-top').length)
    {
        if ($(window).scrollTop() < ($(window).height() / 2))
        {
            $('.aw-back-top').fadeIn();
        }
        else
        {
            $('.aw-back-top').fadeOut();
        }
    }
});