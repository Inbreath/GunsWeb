/**
 * 初始化商户管理详情对话框
 */
var TMchtInfoDlg = {
    tMchtInfoData : {}
};

/**
 * 清除数据
 */
TMchtInfoDlg.clearData = function() {
    this.tMchtInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
TMchtInfoDlg.set = function(key, val) {
    this.tMchtInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
TMchtInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
TMchtInfoDlg.close = function() {
    parent.layer.close(window.parent.TMcht.layerIndex);
}

/**
 * 收集数据
 */
TMchtInfoDlg.collectData = function() {
    this
    .set('mchtno')
    .set('mchtname')
    .set('briefname')
    .set('state')
    .set('signType')
    .set('publicKey')
    .set('privateKey')
    .set('md5key')
    .set('refundFlag')
    .set('createTime')
    .set('refreshTime')
    .set('categoryid')
    .set('mallCode')
    .set('note');
}

/**
 * 提交添加
 */
TMchtInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/tMcht/add", function(data){
        Feng.success("添加成功!");
        window.parent.TMcht.table.refresh();
        TMchtInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.tMchtInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
TMchtInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/tMcht/update", function(data){
        Feng.success("修改成功!");
        window.parent.TMcht.table.refresh();
        TMchtInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.tMchtInfoData);
    ajax.start();
}

$(function() {

});
