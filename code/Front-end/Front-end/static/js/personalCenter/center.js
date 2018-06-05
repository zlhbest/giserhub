$(document).ready(function(){
    $("#jsontree").jstree({
        'core':{
            'data':[
                '公有',
                '私有'
            ]
        }
    });
    $("#teamtree").jstree({
        'core':{
            'data':[
                '我创建的团队',
                '我加入的团队'
            ]
        }
    })

    var headicon =$.cookie('giserhub3');
    $("#newuserimg").attr("src",headicon);
    
   
    initFileInput("avatar_uploading_status","http://localhost:8080/UpdateHeadIcon");
    $("#avatar_uploading_status").fileinput({
        uploadUrl: "http://39.106.181.120/giserhub/UpdateHeadIcon",
        // maxFileCount: 5

    });
});


var form = new FormData($("#setting_form")[0]);
form.append("file",$("#avatar_uploading_status")[0]);
function initFileInput(ctrlName, uploadUrl) { 
    var control = $('#' + ctrlName); 
    control.fileinput({
    language: 'zh', //设置语言
    uploadUrl: uploadUrl, //上传的地址
    allowedFileExtensions : ['jpg', 'png','gif'],//接收的文件后缀
    showUpload: false, //是否显示上传按钮
    showCaption: false,//是否显示标题
    browseClass: "btn btn-success", //按钮样式 
    browseLabel: "上传图片",
    dropZoneTitle: "拖拽图片文件到这里",
    autoReplace:true,
    enctype:"multipart/form-data",
    previewFileIcon: "<i class='glyphicon glyphicon-king'></i>", 
    });
}