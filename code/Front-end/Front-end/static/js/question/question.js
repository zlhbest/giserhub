$(document).ready(function () {

    var url= window.location.search;
    var qId = url.substr(1);//问题id

    // $("#aw-add-comment").toggle(function () {
    //     aw_cbox.show()
    // },function () {
    //     aw_cbox.hide()
    // })

// $(".operate").click(function () {
//     $("#aw-comment-box-answer").toggle()
// })


//一级评论框切换

    var aw_cboxFirst=$(".first-aw-comment-box");
    $("#aw-add-comment").click(function () {
        aw_cboxFirst.toggle()
    });


    //二级评论框 切换
    var aw_cboxSecond=$(".second-aw-comment-box");
    // $(".aw-add-edit").click(function () {
    //
    //     $(this).parents(".aw-item").find(".second-aw-comment-box").toggle();
    //     // aw_cboxSecond.toggle()
    // });
    $(document).on("click",".aw-add-edit",function(){
        $(this).parents(".aw-item").find(".second-aw-comment-box").toggle();
    });
    //二级评论内容 切换
    // $(".toggle_second_comment").click(function () {
    //     // var a=$(this).parents(".mod-footer").prop("outerHTML")
    //     $(this).parents(".mod-footer").find(".second_level_comment").toggle();
    // });
    $(document).on("click",".toggle_second_comment",function(){
        $(this).parents(".mod-footer").find(".second_lcomment").toggle();
    })
});