/**
 * @(#)CommonConsts.java, 2019/01/04.
 * <p/>
 */
package com.xpu.example.itext.demo.constant;

import java.util.ArrayList;
import java.util.List;

/**
 * @author L.Wen
 */
public class PDFpoints {

    /*
    直销PDF文档
     */

    public static int[] ZX_PAGES = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16,17};// 直销 pdf模板页码;
    public static int[] QD_PAGES = {1, 2, 3};// 渠道 pdf模板页码;

    private List<float[]> PAGE1 = new ArrayList<>();
    private List<float[]> PAGE4 = new ArrayList<>();
    private List<float[]> PAGE5 = new ArrayList<>();
    private List<float[]> PAGE7 = new ArrayList<>();
    private List<float[]> PAGE8 = new ArrayList<>();
    private List<float[]> PAGE9 = new ArrayList<>();
    private List<float[]> PAGE10 = new ArrayList<>();
    private List<float[]> PAGE11 = new ArrayList<>();
    private List<float[]> PAGE13 = new ArrayList<>();
    private List<float[]> PAGE14 = new ArrayList<>();
    private List<float[]> PAGE15 = new ArrayList<>();
    // 新增的 综合业务受理登记表
    private List<float[]> PAGE16 = new ArrayList<>();
    //企业呼转号码承诺书
    private List<float[]> PAGE17 = new ArrayList<>();
    /*
    渠道PDF文档
     */
    private List<float[]> QD1 = new ArrayList<>();
    private List<float[]> QD2 = new ArrayList<>();
    private List<float[]> QD3 = new ArrayList<>();


    public PDFpoints() {

        // 字体的高度
        float height = 12f;
        List<float[]> list;
        // 第 1 页填写区域
        list = new ArrayList<>();
        float[] PAGE1_1 = {127.81f, 663.77f, 200.0f, height};//甲方
        float[] PAGE1_2 = {127.81f, 643.17f, 300.0f, height};//地址
        float[] PAGE1_3 = {221.57f, 619.52f, 60.0f, height};//负责人
        float[] PAGE1_4 = {96.7f, 331.62f, 104.5f, height};//400号码
        float[] PAGE1_5 = {364.94f, 331.62f, 104.5f, height};//服务
        list.add(PAGE1_1);
        list.add(PAGE1_2);
        list.add(PAGE1_3);
        list.add(PAGE1_4);
        list.add(PAGE1_5);
        this.PAGE1.addAll(list);

        // 第 4 页填写区域
        list = new ArrayList<>();
        float[] PAGE4_1 = {179.48f, 487.56f, 14.0f, height};//呼叫量
        float[] PAGE4_2 = {152.98f, 419.02f, 61.0f, height};//通话费
        float[] PAGE4_3 = {311.26f, 355.43f, 66.0f, height};//范围内
        float[] PAGE4_4 = {121.18f, 333f, 50f, height};//省
        float[] PAGE4_5 = {180.19f, 177.71f, 173f, height};//开户行
        float[] PAGE4_6 = {192.9f, 157.22f, 231f, height};//银行地址
        float[] PAGE4_7 = {166f, 135.67f, 184.0f, height};//户名
        float[] PAGE4_8 = {166f, 112f, 184f, height};//账号
        float[] PAGE4_9 = {221.52f, 90.51f, 208f, height};//纳税人识别号
        list.add(PAGE4_1);
        list.add(PAGE4_2);
        list.add(PAGE4_3);
        list.add(PAGE4_4);
        list.add(PAGE4_5);
        list.add(PAGE4_6);
        list.add(PAGE4_7);
        list.add(PAGE4_8);
        list.add(PAGE4_9);
        this.PAGE4.addAll(list);

        // 第 5 页填写区域
        list = new ArrayList<>();
        float[] PAGE5_1 = {165.7f, 750.77f, 179.0f, height};//地址
        float[] PAGE5_2 = {165.7f, 728.87f, 111.0f, height};//电话
        float[] PAGE5_3 = {95.95f, 486.5f, 82f, height};//乙方预付费
        list.add(PAGE5_1);
        list.add(PAGE5_2);
        list.add(PAGE5_3);
        this.PAGE5.addAll(list);
        // 第 7 页填写区域
        list = new ArrayList<>();
        float[] PAGE7_1 = {306f, 531.37f, 17f, height};//服务期限
        list.add(PAGE7_1);
        this.PAGE7.addAll(list);
        // 第 8 页填写区域
        list = new ArrayList<>();
        float[] PAGE8_1 = {166.05f, 488.27f, 228.0f, height};//甲方 公司名称
        float[] PAGE8_2 = {193.96f, 468.48f, 300.0f, height};//地址
        float[] PAGE8_3 = {206.5f, 444.46f, 80.0f, height};//联系人
        float[] PAGE8_4 = {193.96f, 423.97f, 110f, height};//电话
        float[] PAGE8_5 = {193.96f, 402.41f, 110f, height};//传真
        float[] PAGE8_6 = {193.96f, 380.51f, 110f, height};//邮编
        list.add(PAGE8_1);
        list.add(PAGE8_2);
        list.add(PAGE8_3);
        list.add(PAGE8_4);
        list.add(PAGE8_5);
        list.add(PAGE8_6);
        this.PAGE8.addAll(list);
        // 第 9 页填写区域
        list = new ArrayList<>();
        float[] PAGE9_1 = {96.8f, 619.7f, 170f, height};//甲方 公司名称
        list.add(PAGE9_1);
        this.PAGE9.addAll(list);
        // 第 10 页填写区域
        list = new ArrayList<>();
        float[] PAGE10_1 = {353.31f, 685.41f, 130.0f, height};//编号
        float[] PAGE10_2 = {137.69f, 624f, 260.0f, height};//客户名称
        float[] PAGE10_3 = {137.69f, 595.97f, 139.0f, height};//营业执照编号
        float[] PAGE10_4 = {399.42f, 595.97f, 139f, height};//企业组织代码证号
        float[] PAGE10_5 = {137.69f, 569.34f, 300f, height};//通信地址
        float[] PAGE10_6 = {137.69f, 541.66f, 55.0f, height};//联系人
        float[] PAGE10_7 = {307.97f, 541.66f, 80.0f, height};//联系电话
        float[] PAGE10_8 = {469.49f, 541.66f, 70f, height};//邮政编码
        float[] PAGE10_9 = {163.27f, 420.79f, 82f, height};//400业务号码
        float[] PAGE10_10 = {423.24f, 420.79f, 119.0f, height};//开通变更日期
        float[] PAGE10_11 = {163.27f, 393.46f, 90.0f, height};//对应小号码
        float[] PAGE10_12 = {177.28f, 370.34f, 70.0f, height};//目的号码1
        float[] PAGE10_13 = {270.83f, 370.34f, 70.0f, height};//目的号码2
        float[] PAGE10_14 = {437.96f, 370.34f, 70.0f, height};//目的号码3
        float[] PAGE10_15 = {163.27f, 337.4f, 80.0f, height};//套餐类型
        float[] PAGE10_16 = {423f, 337.4f, 80.0f, height};//优惠资费
        float[] PAGE10_17 = {163.27f, 310.07f, 60f, height};//套餐金额
        float[] PAGE10_18 = {423f, 310.07f, 35f, height};//套餐年限
        float[] PAGE10_19 = {163.27f, 282.04f, 35f, height};//套餐内通话时长
        float[] PAGE10_20 = {423f, 282.04f, 35.0f, height};//超出套餐资费
        float[] PAGE10_21 = {163.27f, 252.61f, 380.0f, height};//补充说明
        float[] PAGE10_22 = {163.27f, 197.61f, 260f, height};//申请单位名称
        float[] PAGE10_23 = {163.27f, 168.88f, 80f, height};//申请单位经办人
        float[] PAGE10_24 = {399.77f, 168.88f, 145.0f, height};//电话
        float[] PAGE10_25 = {163.27f, 146.1f, 80.0f, height};//手机
        float[] PAGE10_26 = {399.77f, 146.1f, 145f, height};//邮箱
        float[] PAGE10_27 = {163.27f, 90.74f, 85f, height};//经办单位
        float[] PAGE10_28 = {399.77f, 90.74f, 55f, height};//经办人
        // 申请日期
        float[] PAGE10_29 = {155.21f, 685.41f, 22f, height};//年
        float[] PAGE10_30 = {206.36f, 685.41f, 22f, height};//月
        float[] PAGE10_31 = {246.5f, 685.41f, 22f, height};//日
        list.add(PAGE10_1);
        list.add(PAGE10_2);
        list.add(PAGE10_3);
        list.add(PAGE10_4);
        list.add(PAGE10_5);
        list.add(PAGE10_6);
        list.add(PAGE10_7);
        list.add(PAGE10_8);
        list.add(PAGE10_9);
        list.add(PAGE10_10);
        list.add(PAGE10_11);
        list.add(PAGE10_12);
        list.add(PAGE10_13);
        list.add(PAGE10_14);
        list.add(PAGE10_15);
        list.add(PAGE10_16);
        list.add(PAGE10_17);
        list.add(PAGE10_18);
        list.add(PAGE10_19);
        list.add(PAGE10_20);
        list.add(PAGE10_21);
        list.add(PAGE10_22);
        list.add(PAGE10_23);
        list.add(PAGE10_24);
        list.add(PAGE10_25);
        list.add(PAGE10_26);
        list.add(PAGE10_27);
        list.add(PAGE10_28);
        list.add(PAGE10_29);
        list.add(PAGE10_30);
        list.add(PAGE10_31);
        this.PAGE10.addAll(list);
        // 第 11 页填写区域
        list = new ArrayList<>();
        float[] PAGE11_1 = {334.95f, 605.08f, 80.0f, height};//一次性开通费用
        float[] PAGE11_2 = {442.51f, 605.08f, 80.0f, height};//备注
        float[] PAGE11_3 = {334.95f, 538.86f, 80.0f, height};//功能使用费
        float[] PAGE11_4 = {442.51f, 548f, 80f, height};//增值服务内容1
        float[] PAGE11_5 = {442.51f, 533f, 80f, height};//增值服务内容2
        float[] PAGE11_6 = {442.51f, 518, 80f, height};//增值服务内容3
        float[] PAGE11_7 = {442.51f, 503f, 80f, height};//增值服务内容4
        float[] PAGE11_8 = {442.51f, 488f, 80f, height};//增值服务内容5
        float[] PAGE11_9 = {442.51f,473f , 80f, height};//增值服务内容6
        float[] PAGE11_10= {334.93f, 398.94f, 27f, height};//保底
        float[] PAGE11_11= {334.93f, 366.79f, 27f, height};//套餐内通话时长
        float[] PAGE11_12= {334.93f, 336.05f, 27f, height};//超出套餐资费
        float[] PAGE11_13= {442.51f, 426.1f, 80f, height};//备注
        list.add(PAGE11_1);
        list.add(PAGE11_2);
        list.add(PAGE11_3);
        list.add(PAGE11_4);
        list.add(PAGE11_5);
        list.add(PAGE11_6);
        list.add(PAGE11_7);
        list.add(PAGE11_8);
        list.add(PAGE11_9);
        list.add(PAGE11_10);
        list.add(PAGE11_11);
        list.add(PAGE11_12);
        list.add(PAGE11_13);
        this.PAGE11.addAll(list);
        // 第 13 页填写区域
        list = new ArrayList<>();
        float[] PAGE13_1 = {170.65f, 289.4f, 260.0f, height};//单位全称
        float[] PAGE13_2 = {276.64f, 268.73f, 55.0f, height};//委托人姓名
        float[] PAGE13_3 = {170.65f, 248.76f, 300.0f, height};//单位地址
        float[] PAGE13_4 = {180.79f, 226.69f, 55f, height};//联系人姓名
        float[] PAGE13_5 = {428.5f, 226.69f, 80f, height};//联系人电话
        list.add(PAGE13_1);
        list.add(PAGE13_2);
        list.add(PAGE13_3);
        list.add(PAGE13_4);
        list.add(PAGE13_5);
        this.PAGE13.addAll(list);
        // 第 14 页填写区域
        list = new ArrayList<>();
//        float[] PAGE14_1 = {215.12f, 692.5f, 260.0f, height};//甲方名称
        float[] PAGE14_1 = {250f, 622f, 260.0f, height};//甲方名称
        float[] PAGE14_2 = {250f, 590f, 120.0f, height};//业务需求单编号
        float[] PAGE14_3 = {250f, 575f, 120.0f, height};//400业务开通日期
        float[] PAGE14_4 = {250f, 559f, 120f, height};//400业务服务期限
        float[] PAGE14_5 = {200f, 485.0f, 70f, height};//400号码
        float[] PAGE14_6 = {278f, 485.0f, 64.0f, height};//增值服务一
        float[] PAGE14_7 = {349f, 485.0f, 64.0f, height};//增值服务二
        float[] PAGE14_8 = {429f, 485.0f, 64f, height};//增值服务三
        float[] PAGE14_9 = {499f, 485.0f, 52f, height};//其他
//        float[] PAGE14_10 = {93.9f, 540.26f, 61.0f, height};//第二行 2
//        float[] PAGE14_11 = {164.99f, 540.26f, 70.0f, height};//400号码
//        float[] PAGE14_12 = {242.8f, 540.26f, 64.0f, height};//增值服务一
//        float[] PAGE14_13 = {312.52f, 540.26f, 64.0f, height};//增值服务二
//        float[] PAGE14_14 = {364.94f, 540.26f, 64.0f, height};//增值服务三
//        float[] PAGE14_15 = {461.78f, 540.26f, 52.0f, height};//其他
        float[] PAGE14_16 = {250f, 398f, 92.0f, height};//甲方名称（盖公章）
        list.add(PAGE14_1);
        list.add(PAGE14_2);
        list.add(PAGE14_3);
        list.add(PAGE14_4);
        list.add(PAGE14_5);
        list.add(PAGE14_6);
        list.add(PAGE14_7);
        list.add(PAGE14_8);
        list.add(PAGE14_9);
//        list.add(PAGE14_10);
//        list.add(PAGE14_11);
//        list.add(PAGE14_12);
//        list.add(PAGE14_13);
//        list.add(PAGE14_14);
//        list.add(PAGE14_15);

        list.add(PAGE14_16);
        this.PAGE14.addAll(list);
        // 第 15 页填写区域
        list = new ArrayList<>();
        float[] PAGE15_1 = {146.45f, 601f, 55.0f, height};// 身份证号
        float[] PAGE15_2 = {278.54f, 601f, 170.0f, height};// 姓名
        float[] PAGE15_3 = {374.15f, 273f, 200.0f, height};// 公司名称
        list.add(PAGE15_1);
        list.add(PAGE15_2);
        list.add(PAGE15_3);
        this.PAGE15.addAll(list);

        // 第 16 页填写区域
        list = new ArrayList<>();
        float[] PAGE16_1 = {150f, 681.11f, 30f, height};//申请日期 年
        float[] PAGE16_2 = {209.52f, 681.11f, 15f, height};//月
        float[] PAGE16_3 = {252.61f, 681.11f, 15f, height};//日
        float[] PAGE16_4 = {138.74f, 620.15f, 260f, height};//客户名称
        float[] PAGE16_5 = {138.74f, 597.38f, 55f, height};//联系人
        float[] PAGE16_6 = {268.73f, 597.38f, 120f, height};//联系电话
        float[] PAGE16_7 = {138.74f, 574.25f, 120f, height};//业务号码
        float[] PAGE16_8 = {163.72f, 428.15f, 260f, height};//申请单位名称
        float[] PAGE16_9 = {163.72f, 400.82f, 55f, height};//经办人
        float[] PAGE16_10 = {399.77f, 400.82f, 120f, height};//电话
        float[] PAGE16_11 = {163.72f, 378.04f, 85f, height};//手机
        float[] PAGE16_12 = {399.77f, 378.04f, 120f, height};//邮箱
        float[] PAGE16_13 = {163.72f, 306.92f, 85f, height};//经办单位
        float[] PAGE16_14 = {399.77f, 306.92f, 55f, height};//经办人

        list.add(PAGE16_1);
        list.add(PAGE16_2);
        list.add(PAGE16_3);
        list.add(PAGE16_4);
        list.add(PAGE16_5);
        list.add(PAGE16_6);
        list.add(PAGE16_7);
        list.add(PAGE16_8);
        list.add(PAGE16_9);
        list.add(PAGE16_10);
        list.add(PAGE16_11);
        list.add(PAGE16_12);
        list.add(PAGE16_13);
        list.add(PAGE16_14);
        this.PAGE16.addAll(list);

        // 第 17 页填写区域
        list = new ArrayList<>();
        float[] PAGE17_1 = {157f,740.3f, 60f, height};//短号码
        float[] PAGE17_2 = {91f, 632.11f, 60f, height};//呼转号码1
        float[] PAGE17_3 = {91f, 608.11f, 60f, height};//呼转号码2
        float[] PAGE17_4 = {91f, 585.11f, 60f, height};//呼转号码3
        float[] PAGE17_5 = {120.06f, 396.97f, 260f, height};//单位全称
        float[] PAGE17_6 = {120.06f, 365.77f, 260f, height};//单位地址
        float[] PAGE17_7 = {127.06f, 334.57f, 60f, height};//联系人姓名
        float[] PAGE17_8 = {127.06f, 303.34f, 60f, height};//联系人电话
        list.add(PAGE17_1);
        list.add(PAGE17_2);
        list.add(PAGE17_3);
        list.add(PAGE17_4);
        list.add(PAGE17_5);
        list.add(PAGE17_6);
        list.add(PAGE17_7);
        list.add(PAGE17_8);
        this.PAGE17.addAll(list);
        /*
        渠道PDF文档参数
         */
        // 渠道 第 1 页填写区域
        list = new ArrayList<>();
        float[] QD1_1 = {105.46f, 152.76f, 150f, height};// 甲方单位名称
        list.add(QD1_1);
        this.QD1.addAll(list);
        // 渠道 第 2 页填写区域
        list = new ArrayList<>();
        float[] QD2_1 = {152.41f, 149.61f, 150f, height};// 甲方单位名称
        float[] QD2_2 = {230.89f, 136.64f, 50f, height};// 法人姓名
        float[] QD2_3 = {152.41f, 121.93f, 200f, height};// 甲方单位地址
        float[] QD2_4 = {159.77f, 108.26f, 50f, height};// 甲方联系人
        float[] QD2_5 = {345.46f, 108.26f, 70f, height};// 甲方联系电话
        list.add(QD2_1);
        list.add(QD2_2);
        list.add(QD2_3);
        list.add(QD2_4);
        list.add(QD2_5);
        this.QD2.addAll(list);

        // 渠道 第 3 页填写区域
        list = new ArrayList<>();
        float[] QD3_1 = {184.64f, 717.9f, 20.0f, height};//年
        float[] QD3_2 = {222.48f, 717.9f, 10.0f, height};//月
        float[] QD3_3 = {256.47f, 717.9f, 10.0f, height};//日
        float[] QD3_4 = {333.55f, 717.9f, 100f, height};//业务需求单编号
        float[] QD3_5 = {172.38f, 654.83f, 200f, height};//客户名称
        float[] QD3_6 = {172.38f, 622.95f, 100f, height};//营业执照编号
        float[] QD3_7 = {378.04f, 622.95f, 100f, height};//组织机构代码
        float[] QD3_8 = {172.38f, 594.92f, 200f, height};//地址
        float[] QD3_9 = {172.38f, 563.5f, 45f, height};//联系人
        float[] QD3_10 = {304.47f, 563.5f, 65f, height};//联系电话
        float[] QD3_11 = {432.7f, 563.5f, 50f, height};//邮政编码
        float[] QD3_12 = {190.6f, 432.7f, 65f, height};//400号码
        float[] QD3_13 = {396.26f, 432.7f, 65f, height};//开通日期
        float[] QD3_14 = {190.6f, 402.57f, 65f, height};//对应小号码（引示号）
        float[] QD3_15 = {203.91f, 376.64f, 55f, height};//目的号码1
        float[] QD3_16 = {279.94f, 376.64f, 55f, height};//目的号码2
        float[] QD3_17 = {410.63f, 376.64f, 55f, height};//目的号码3
        float[] QD3_18 = {190.6f, 346.86f, 300f, height};//补充说明
        float[] QD3_19 = {190.6f, 283.8f, 200f, height};//申请单位名称
        float[] QD3_20 = {190.6f, 248.41f, 50f, height};//经办人
        float[] QD3_21 = {378.39f, 248.41f, 70f, height};//电话
        float[] QD3_22 = {190.6f, 222.48f, 65f, height};//手机
        float[] QD3_23 = {378.39f, 222.48f, 110f, height};//邮箱
        float[] QD3_24 = {188.5f, 170f, 68f, height};//经办单位
        float[] QD3_25 = {377f, 170f, 50f, height};//经办人
        list.add(QD3_1);
        list.add(QD3_2);
        list.add(QD3_3);
        list.add(QD3_4);
        list.add(QD3_5);
        list.add(QD3_6);
        list.add(QD3_7);
        list.add(QD3_8);
        list.add(QD3_9);
        list.add(QD3_10);
        list.add(QD3_11);
        list.add(QD3_12);
        list.add(QD3_13);
        list.add(QD3_14);
        list.add(QD3_15);
        list.add(QD3_16);
        list.add(QD3_17);
        list.add(QD3_18);
        list.add(QD3_19);
        list.add(QD3_20);
        list.add(QD3_21);
        list.add(QD3_22);
        list.add(QD3_23);
        list.add(QD3_24);
        list.add(QD3_25);
        this.QD3.addAll(list);


    }

    public List<float[]> getPAGE1() {
        return PAGE1;
    }

    public List<float[]> getPAGE4() {
        return PAGE4;
    }

    public List<float[]> getPAGE5() {
        return PAGE5;
    }

    public List<float[]> getPAGE7() {
        return PAGE7;
    }

    public List<float[]> getPAGE8() {
        return PAGE8;
    }

    public List<float[]> getPAGE9() {
        return PAGE9;
    }

    public List<float[]> getPAGE10() {
        return PAGE10;
    }

    public List<float[]> getPAGE11() {
        return PAGE11;
    }

    public List<float[]> getPAGE13() {
        return PAGE13;
    }

    public List<float[]> getPAGE14() {
        return PAGE14;
    }

    public List<float[]> getPAGE15() {
        return PAGE15;
    }

    public List<float[]> getPAGE16() {
        return PAGE16;
    }

    public List<float[]> getPAGE17() {
        return PAGE17;
    }

    public List<float[]> getQD1() {
        return QD1;
    }

    public List<float[]> getQD2() {
        return QD2;
    }

    public List<float[]> getQD3() {
        return QD3;
    }

}