/**
 * 商户管理管理初始化
 */
var TMcht = {
    id: "TMchtTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
TMcht.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '银商商户号', field: 'mchtno', visible: true, align: 'center', valign: 'middle'},
            {title: '商户名称', field: 'mchtname', visible: true, align: 'center', valign: 'middle'},
            {title: '商户简称', field: 'briefname', visible: true, align: 'center', valign: 'middle'},
            {title: '商户状态', field: 'state', visible: true, align: 'center', valign: 'middle'},
            {title: '签名类型', field: 'signType', visible: true, align: 'center', valign: 'middle'},
            {title: '公钥', field: 'publicKey', visible: true, align: 'center', valign: 'middle'},
            {title: '私钥，预留字段', field: 'privateKey', visible: true, align: 'center', valign: 'middle'},
            {title: 'MD5校验值', field: 'md5key', visible: true, align: 'center', valign: 'middle'},
            {title: '是否允许隔日退货', field: 'refundFlag', visible: true, align: 'center', valign: 'middle'},
            {title: '创建时间', field: 'createTime', visible: true, align: 'center', valign: 'middle'},
            {title: '更新时间', field: 'refreshTime', visible: true, align: 'center', valign: 'middle'},
            {title: '商户类别，详见类目表', field: 'categoryid', visible: true, align: 'center', valign: 'middle'},
            {title: '所属综合体,取值为T_MALL的CODE', field: 'mallCode', visible: true, align: 'center', valign: 'middle'},
            {title: '备注', field: 'note', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
TMcht.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        TMcht.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加商户管理
 */
TMcht.openAddTMcht = function () {
    var index = layer.open({
        type: 2,
        title: '添加商户管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/tMcht/tMcht_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看商户管理详情
 */
TMcht.openTMchtDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '商户管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/tMcht/tMcht_update/' + TMcht.seItem.mchtno
        });
        this.layerIndex = index;
    }
};

/**
 * 删除商户管理
 */
TMcht.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/tMcht/delete", function (data) {
            Feng.success("删除成功!");
            TMcht.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("tMchtId",this.seItem.mchtno);
        ajax.start();
    }
};

/**
 * 查询商户管理列表
 */
TMcht.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    TMcht.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = TMcht.initColumn();
    var table = new BSTable(TMcht.id, "/tMcht/list", defaultColunms);
    table.setPaginationType("client");
    TMcht.table = table.init();
});
