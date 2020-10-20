package com.sun.power.core.common.constant;

/**
 * 常量类
 *
 * @author 贾涛
 * @date 2018年12月13日  修改
 */

public final class SysConstant {

    private SysConstant() {
        throw new IllegalStateException("初始化");
    }

    public static final String PARAM_NAME_TOKEN             = "token";
    public static final String PARAM_NAME_IS_TOP            = "isTop";
    public static final long TOKEN_TIMEOUT                  = 6000;
    public static final String BLOGIC_CONTENT_TYPE = "application/json;UTF-8";
    public static final String KEY = "liantong20190410";
    public static final String PARAM_USER_INFO_ORG_ID       = "orgId";
    public static final String PARAM_USER_INFO_USER_NAME    = "username";
    public static final String CREATE_ORG_ID                = "create_org_id";
    public static final String CREATE_ORG_PARENT_ID         = "create_org_parent_id";
    public static final String PARAM_NAME_PROVINCE_FOR_APP  = "provinceForApp";
    public static final String PARAM_NAME_CITY_FOR_APP      = "cityForApp";
    public static final String PARAM_NAME_DISTRICT_FOR_APP  = "districtForApp";
    public static final String PARAM_NAME_ORGID_FOR_DATA_SELECT = "orgIdForDataSelect";
    public static final String DEFAULT = "default";
    public static final String PARAM_NAME_ALL_INDEX_SELECT = "allIndex";
    public static final String PARAM_NAME_NO_DATA_AUTH      = "isNoDataAuth";               //无权限校验
   // public static final String BLOGIC_CONTENT_TYPE = "application/x-www-form-urlencoded";
    public static final String BLOGIC_DEFAULT_SUBMIT = "Login";
    public static final String BLOGIC_DEFAULT_NONCE_STR = "CDLGBAPP";
    public static final String apps="%s_%s";
    public static final String LGBMARK="APP";
    public static final String LGBPC="PC";
    public static final String ACTIVE="PROD";
    public static final int ORGANIZATION_LEVEL_PROVINCE = 1;
    public static final int ORGANIZATION_LEVEL_CITY = 2;
    public static final int ORGANIZATION_LEVEL_DISTRICT = 3;
    public static final int DEFAULT_PAGE_SIZE = 20;         //默认分页大小
    public static final int DEFAULT_CURRENT_PAGE = 1;       //默认开始页数
    public static final int TRUE = 1;                       //是
    public static final int FALSE = 0;                      //否
    public static final int ROOT_ORGANIZATION_ID = 0;       //根组织id

    //字典固定值
    public static final long DICTIONARY_VALUE_IS_DEAD = 178;
    public static final long DEFAULT_DING_TALK_ID = 1;
    public static final String DEFAULT_PASSWORD = "e10adc3949ba59abbe56e057f20f883e";

    public static final String PARAM_NAME_ACCESSTOKEN_BAIDU_IN_REDIS = "baiduAccessToken";
    public static final long DEFAULT_BAIDU_ACCESSTOKEN_TIMEOUT = 25;

    //搜索所有区县参数值
    public static final String ORGANIZATION_SELECT_DISTRICT = "区";
    public static final String DDINGTALKE_ACCESS_KEY = "lgbsmpDingTalkKey@2018";
    public static final String DDINGTALKE_ACCESS_USERNAME_PRE = "lgbsmpDingTalk#";
    public static final String DDINGTALKE_ACCESS_USERNAME_PRE_STR = "lgbsmpDingTalk";

    public static final Integer RETUEN_NEWS_PROVINCE_LEVEL_RETUEN_NEWS = 6;
    public static final Integer RETUEN_NEWS_CITY_LEVEL_RETUEN_NEWS = 3;
    public static final Integer RETUEN_NEWS_DISTRICT_LEVEL_RETUEN_NEWS = 2;
    public static final Integer RETUEN_NEWS_RELEASE = 1;
    public static final String DEPARTMENT_OF_RETIREMENT_AFFAIRS = "老干部局";

    public static final Long STATISTICAL_SELECT_START = 1L;
    public static final Long STATISTICAL_SELECT_END = 11L;
    public static final String STATISTICAL_TOTAL = "合计";

    public static final long PROVINCE_PARENT_ID = 0;
    public static final String PROVINCE_PARENT_NAME = "浙江省";
    public static final long PROVINCE_PARENT_DEFAULT_DING_TALK_ID = 0;

    public static final long HEALTH_STATUS_HEALTH = 87L;        //健康
    public static final long HEALTH_STATUS_COMMON = 88L;        //一般
    public static final long HEALTH_STATUS_CANNOT_TAKE_CARE_ONESELF = 89L;  //不能自理
    public static final long HEALTH_STATUS_OTHERS = 90;         //其他

    //钉钉系统接收httpRequestType
    public static final String JSON_CONTENT_TYPE = "application/json; charset=UTF-8";
    public static final int DING_TALK_SUCCESS_CODE = 0;
    public static final String IS_DINGTALK_SEND_DATA_TRUE = "1";
    public static final long DING_TALK_DEFAULT_DEPT_ID = 1; //钉钉默认祖宗组织id

    //http返回状态码
    public static final int REUTRN_CODE_AUTHORITY_ERROR = 555;

    public static final long HELPER = 175L;
    public static final long HOMEMAKING = 174L;

    public static final String[] county = {"上城区", "下城区", "江干区", "拱墅区", "西湖区", "滨江区", "萧山区",
            "余杭区", "富阳区", "临安区", "桐庐县", "淳安县", "建德市", "其他"};

    //住院管理APP请求数据标识
    public static final long APP_REQUEST_FOR_HOSPITALIZATION = 2L;

    //宣传调研1-4类活动及健康休养和其他类型活动附件标识
    public static final long DICT_ENCLOSURE_USE_ACTIVITY = 161L;

    //市委老干部局单位id
    public static final Long CD_LGB_MINISTRY_ORG_ID = 1L;

    /***
     * 活动推送审核不通过
     */
    public static final int DICT_APPROVAL_STATUS = 2;

    /***
     * 市委老干部局id
     */
    public static final String LGB_ORG_ID = "1000";
    /***
     * 市直系统
     */
    public static final String COMPANY_1 = "1000-1000";
    /**
     * 宣传系统
     */
    public static final String COMPANY_2 = "1000-1001";
    /***
     * 教育系统
     */
    public static final String COMPANY_3 = "1000-1003";
    /***
     * 政法系统
     */
    public static final String COMPANY_4 = "1000-1004";
    /***
     * 农工委系统
     */
    public static final String COMPANY_5 = "1000-1005";
    /***
     * 国资委系统
     */
    public static final String COMPANY_6 = "1000-1006";
    /***
     * 东城区
     */
    public static final String COMPANY_7 = "1000-1007";
    /***
     * 西城区
     */
    public static final String COMPANY_8 = "1000-1008";
    /**
     * 朝阳区
     */
    public static final String COMPANY_9 = "1000-1009";
    /***
     * 海淀区
     */
    public static final String COMPANY_10 = "1000-1010";
    /**
     * 丰台区
     */
    public static final String COMPANY_11 = "1000-1011";
    /***
     * 石景山区
     */
    public static final String COMPANY_12 = "1000-1012";
    /***
     * 门头沟区
     */
    public static final String COMPANY_13 = "1000-1013";
    /***
     * 房山区
     */
    public static final String COMPANY_14 = "1000-1014";
    /**
     * 通州区
     */
    public static final String COMPANY_15 = "1000-1015";
    /***
     * 顺义区
     */
    public static final String COMPANY_16 = "1000-1016";
    /***
     * 大兴区
     */
    public static final String COMPANY_17 = "1000-1017";
    /***
     * 昌平区
     */
    public static final String COMPANY_18 = "1000-1018";
    /**
     * 平谷区
     */
    public static final String COMPANY_19 = "1000-1019";
    /***
     * 怀柔区
     */
    public static final String COMPANY_20 = "1000-1020";
    /**
     * 密云区
     */
    public static final String COMPANY_21 = "1000-1021";
    /***
     * 延庆区
     */
    public static final String COMPANY_22 = "1000-1022";
    /***
     *统战系统
     */
    public static final String COMPANY_23 = "1000-1025";

    /***
     * 市属单位
     */
    public static final String[] UNDER_THE_UNIT = {"市直系统", "宣传系统", "教育系统", "政法系统", "农工委系统", "国资委系统", "统战系统"};

    /***
     * 城区单位
     */
    public static final String[] URBAN_AREA = {"东城区", "西城区", "朝阳区", "海淀区", "丰台区", "石景山区"};

    /***
     * 郊区单位
     */
    public static final String[] SUBURB = {"门头沟区", "房山区", "通州区", "顺义区", "大兴区", "昌平区", "平谷区", "怀柔区", "密云区", "延庆区"};


    /***
     * 市属单位
     */
    public static final String[] SYSTEMATIC_1 = {"1000-1000", "1000-1001","1000-1003","1000-1004", "1000-1005","1000-1006","1000-1025"};
    /***
     * 城区单位
     */
    public static final String[] SYSTEMATIC_2 = {"1000-1007", "1000-1008","1000-1009","1000-1010","1000-1011","1000-1012"};
    /***
     * 郊区单位
     */
    public static final String[] SYSTEMATIC_3 = {"1000-1013","1000-1014","1000-1015","1000-1016","1000-1017","1000-1018","1000-1019","1000-1020","1000-1021","1000-1022"};


   /***
    * 本级（市局）id
    */
   public static final String LGB_CITY_ID = "40fd998a6f42a78d016f45ff33ee";
}
