package cn.lili.common.enums;

/**
 * 返回状态码
 * 第一位 1:商品；2:用户；3:交易,4:促销,5:店铺,6:页面,7:设置,8:其他
 *
 * @author Chopper
 * @since 2020/4/8 1:36 下午
 */
public enum ResultCode {

    /**
     * success status code
     */
    SUCCESS(200, "Success"),

    /**
     * Failed return code
     */
    ERROR(400, "The server is busy, please try again later"),

    /**
     * Failed return code
     */
    DEMO_SITE_EXCEPTION(4001, "Demo site prohibited"),
    /**
     * parameter exception
     */
    PARAMS_ERROR(4002, "parameter abnormal"),


    /**
     * System exception
     */
    WECHAT_CONNECT_NOT_EXIST(1001, "Wechat joint login is not configured"),
    VERIFICATION_EXIST(1002, "Verification code service abnormal"),
    LIMIT_ERROR(1003, "Access too frequently, please try again later"),
    ILLEGAL_REQUEST_ERROR(1004, "Illegal request, please refresh the page again"),
    IMAGE_FILE_EXT_ERROR(1005, "Image format not supported"),
    FILE_TYPE_NOT_SUPPORT(1010, "The uploaded file type is not supported!"),
    PLATFORM_NOT_SUPPORTED_IM(1006, "IM is not enabled on the platform"),
    STORE_NOT_SUPPORTED_IM(1007, "The store has not opened IM"),
    UNINITIALIZED_PASSWORD(1008, "Uninitialized password, cannot be initialized"),
    /**
     * Classification
     */
    CATEGORY_NOT_EXIST(10001, "The product category does not exist"),
    CATEGORY_NAME_IS_EXIST(10002, "The category name already exists"),
    CATEGORY_PARENT_NOT_EXIST(10003, "The category name already exists"),
    CATEGORY_BEYOND_THREE(10004, "At most three-level classification, failed to add"),
    CATEGORY_HAS_CHILDREN(10005, "There are subcategories under this category and cannot be deleted"),
    CATEGORY_HAS_GOODS(10006, "The goods in this category cannot be deleted"),
    CATEGORY_SAVE_ERROR(10007, "There are products in this category that cannot be deleted"),
    CATEGORY_PARAMETER_NOT_EXIST(10012, "Category binding parameter group does not exist"),
    CATEGORY_PARAMETER_SAVE_ERROR(10008, "Failed to add category binding parameter group"),
    CATEGORY_PARAMETER_UPDATE_ERROR(10009, "Failed to add category binding parameter group"),
    CATEGORY_DELETE_FLAG_ERROR(10010, "Subclass status cannot be inconsistent with parent class!"),
    CATEGORY_COMMISSION_RATE_ERROR(10011, "Category commission is incorrect!"),

    /**
     * Commodity
     */
    GOODS_ERROR(11001, "The item is abnormal, please try again later"),
    GOODS_NOT_EXIST(11001, "The product has been removed from the shelves"),
    GOODS_NAME_ERROR(11002, "The product name is incorrect, the name should be 2-50 characters"),
    GOODS_UNDER_ERROR(11003, "Failed to remove the product from the shelf"),
    GOODS_UPPER_ERROR(11004, "Commodity listing failed"),
    GOODS_AUTH_ERROR(11005, "Item review failed"),
    POINT_GOODS_ERROR(11006, "The business of point goods is abnormal, please try again later"),
    POINT_GOODS_NOT_EXIST(11020, "Points item does not exist"),
    POINT_GOODS_CATEGORY_EXIST(11021, "The current category of points product already exists"),
    GOODS_SKU_SN_ERROR(11007, "The product SKU number cannot be empty"),
    GOODS_SKU_PRICE_ERROR(11008, "Product SKU price cannot be less than or equal to 0"),
    GOODS_SKU_COST_ERROR(11009, "Product SKU cost price cannot be less than or equal to 0"),
    GOODS_SKU_WEIGHT_ERROR(11010, "Item weight cannot be negative"),
    GOODS_SKU_QUANTITY_ERROR(11011, "The quantity of goods in stock cannot be negative"),
    GOODS_SKU_QUANTITY_NOT_ENOUGH(11011, "Insufficient product stock"),
    MUST_HAVE_GOODS_SKU(11012, "Specifications must have one!"),
    GOODS_PARAMS_ERROR(11013, "Commodity parameter error, try again after refresh"),
    PHYSICAL_GOODS_NEED_TEMP(11014, "For physical goods, you need to select a delivery template"),
    VIRTUAL_GOODS_NOT_NEED_TEMP(11015, "Virtual goods do not need to select a delivery template"),
    GOODS_NOT_EXIST_STORE(11017, "The current user is not authorized to operate this item"),
    GOODS_TYPE_ERROR(11016, "Need to select a product type"),

    /**
     * parameter
     */
    PARAMETER_SAVE_ERROR(12001, "Parameter addition failed"),
    PARAMETER_UPDATE_ERROR(12002, "Parameter editing failed"),

    /**
     * Specification
     */
    SPEC_SAVE_ERROR(13001, "Specification modification failed"),
    SPEC_UPDATE_ERROR(13002, "Specification modification failed"),
    SPEC_DELETE_ERROR(13003, "The category has been bound to this specification, please disassociate first"),

    /**
     * brand
     */
    BRAND_SAVE_ERROR(14001, "Failed to add brand"),
    BRAND_UPDATE_ERROR(14002, "Brand modification failed"),
    BRAND_DISABLE_ERROR(14003, "Brand disable failed"),
    BRAND_DELETE_ERROR(14004, "Brand deletion failed"),
    BRAND_NAME_EXIST_ERROR(20002, "Duplicate brand name!"),
    BRAND_USE_DISABLE_ERROR(20003, "The category has been bound to the brand, please disassociate first"),
    BRAND_BIND_GOODS_ERROR(20005, "The brand has already bound the product, please disassociate first"),
    BRAND_NOT_EXIST(20004, "Brand does not exist"),

    /**
     * user
     */
    USER_EDIT_SUCCESS(20001, "User modified successfully"),
    USER_NOT_EXIST(20002, "User does not exist"),
    USER_NOT_LOGIN(20003, "User is not logged in"),
    USER_AUTH_EXPIRED(20004, "The user has logged out, please log in again"),
    USER_AUTHORITY_ERROR(20005, "Insufficient authority"),
    USER_CONNECT_LOGIN_ERROR(20006, "No login information found"),
    USER_EXIST(20008, "The username or phone number has been registered"),
    USER_PHONE_NOT_EXIST(20009, "Phone number does not exist"),
    USER_PASSWORD_ERROR(20010, "Incorrect password"),
    USER_NOT_PHONE(20011, "Not the current user's phone number"),
    USER_CONNECT_ERROR(20012, "Joined third-party login, wrong authorization information"),
    USER_RECEIPT_REPEAT_ERROR(20013, "Duplicate member invoice information"),
    USER_RECEIPT_NOT_EXIST(20014, "Member invoice information does not exist"),
    USER_EDIT_ERROR(20015, "User modification failed"),
    USER_OLD_PASSWORD_ERROR(20016, "The old password is incorrect"),
    USER_COLLECTION_EXIST(20017, "Cannot duplicate collection"),
    USER_GRADE_IS_DEFAULT(20018, "The membership level is the default membership level"),
    USER_NOT_BINDING(20020, "User not bound"),
    USER_AUTO_REGISTER_ERROR(20021, "Auto registration failed, please try again later"),
    USER_OVERDUE_CONNECT_ERROR(20022, "The authorization information has expired, please re-authorize/login"),
    USER_CONNECT_BANDING_ERROR(20023, "The current joint login method has been bound to another account and needs to be unbound"),
    USER_CONNECT_NOT_EXIST_ERROR(20024, "There is currently no joint login information, and the one-click registration function cannot be realized. Please click the third-party login to authorize"),
    USER_POINTS_ERROR(20024, "Insufficient user points"),

    /**
     * Permissions
     */
    PERMISSION_DEPARTMENT_ROLE_ERROR(21001, "The role has been bound to the department, please delete one by one"),
    PERMISSION_USER_ROLE_ERROR(21002, "The role has been bound to the administrator, please delete one by one"),
    PERMISSION_MENU_ROLE_ERROR(21003, "The menu is bound to a role, please delete or edit the role first"),
    PERMISSION_DEPARTMENT_DELETE_ERROR(21004, "The department has bound an administrator, please delete or edit the administrator first"),
    PERMISSION_BEYOND_TEN(21005, "Up to 10 roles can be set"),

    /**
     * Distribution
     */
    DISTRIBUTION_CLOSE(22000, "Distribution function is closed"),
    DISTRIBUTION_NOT_EXIST(22001, "Distributor does not exist"),
    DISTRIBUTION_IS_APPLY(22002, "The distributor has applied, no need to resubmit"),
    DISTRIBUTION_AUDIT_ERROR(22003, "Failed to audit distributor"),
    DISTRIBUTION_RETREAT_ERROR(22004, "Failed to clear the distributor"),
    DISTRIBUTION_CASH_NOT_EXIST(22005, "Distributor withdrawal record does not exist"),
    DISTRIBUTION_GOODS_DOUBLE(22006, "Cannot add multiple distribution products"),

    /**
     * shopping cart
     */
    CART_ERROR(30001, "Error reading shopping cart on checkout page"),
    CART_NUM_ERROR(30010, "The purchase quantity must be greater than 0"),
    CART_PINTUAN_NOT_EXIST_ERROR(30002, "The group sharing event has been closed, please try again later"),
    CART_PINTUAN_LIMIT_ERROR(30003, "The number of purchases exceeds the limit of group group activities"),
    SHIPPING_NOT_APPLY(30005, "The shopping item does not support the current delivery address delivery"),

    /**
     * Order
     */
    ORDER_ERROR(31001, "Error creating order, please try again later"),
    ORDER_NOT_EXIST(31002, "Order does not exist"),
    ORDER_DELIVERED_ERROR(31003, "The order status is incorrect, and the receipt cannot be confirmed"),
    ORDER_UPDATE_PRICE_ERROR(31004, "The amount of the paid order cannot be modified"),
    ORDER_LOGISTICS_ERROR(31005, "Logistics Error"),
    ORDER_DELIVER_ERROR(31006, "Logistics Error"),
    ORDER_NOT_USER(31007, "Orders that are not current members"),
    ORDER_TAKE_ERROR(31008, "The current order cannot be written off"),
    MEMBER_ADDRESS_NOT_EXIST(31009, "The order has no delivery address, please configure the delivery address first"),
    ORDER_DELIVER_NUM_ERROR(31010, "No orders to be shipped"),
    ORDER_NOT_SUPPORT_DISTRIBUTION(31011, "The shopping cart contains items that do not support delivery, please re-select the delivery address, or re-select the item"),
    ORDER_NOT_EXIST_VALID(31041, "There are no valid items in the shopping cart, please check the items in the shopping cart, or select the item again"),
    ORDER_CAN_NOT_CANCEL(31012, "The current order status cannot be cancelled"),
    ORDER_BATCH_DELIVER_ERROR(31013, "Batch delivery, file read failed"),
    ORDER_ITEM_NOT_EXIST(31014, "The current line item does not exist!"),
    POINT_NOT_ENOUGH(31015, "The current member's points are not enough to purchase the current points!"),


    /**
     * Pay
     */
    PAY_UN_WANTED(32000, "The current order does not need to be paid, just return to the order list and wait for the system order to be released"),
    PAY_SUCCESS(32001, "Successful payment"),
    PAY_INCONSISTENT_ERROR(32002, "The payment amount does not match the payable amount"),
    PAY_DOUBLE_ERROR(32003, "The order has been paid and cannot be paid again"),
    PAY_CASHIER_ERROR(32004, "Error getting cashier information"),
    PAY_ERROR(32005, "The payment service is abnormal, please try again later"),
    PAY_BAN(32006, "The current order does not require payment, please return to the order list and re-operate"),
    PAY_PARTIAL_ERROR(32007, "The order has been partially paid, please go to the order center to pay"),
    PAY_NOT_SUPPORT(32008, "Payment is not currently supported"),
    PAY_CLIENT_TYPE_ERROR(32009, "Bad client"),
    PAY_POINT_ENOUGH(32010, "Insufficient points, cannot be redeemed"),
    PAY_NOT_EXIST_ORDER(32011, "The payment order does not exist"),
    CAN_NOT_RECHARGE_WALLET(32012, "Cannot use the balance to recharge"),


    /**
     * After sale
     */
    AFTER_SALES_NOT_PAY_ERROR(33001, "The current order has not been paid and cannot apply for after-sales service"),
    AFTER_SALES_CANCEL_ERROR(33002, "The current after-sales order cannot be cancelled"),
    AFTER_SALES_BAN(33003, "The order status does not allow to apply for after-sales, please contact the platform or merchant"),
    AFTER_SALES_DOUBLE_ERROR(33004, "After-sales has been reviewed and cannot be repeated"),
    AFTER_SALES_LOGISTICS_ERROR(33005, "Logistic company error, please select again"),
    AFTER_STATUS_ERROR(33006, "After-sales status error, please refresh the page"),
    RETURN_MONEY_OFFLINE_BANK_ERROR(33007, "When the account type is bank transfer, the bank information cannot be empty"),
    AFTER_SALES_PRICE_ERROR(33004, "The refund amount is incorrect"),
    AFTER_GOODS_NUMBER_ERROR(33008, "The number of after-sales items is incorrect"),

    /**
     * complaint
     */
    COMPLAINT_ORDER_ITEM_EMPTY_ERROR(33100, "Order does not exist"),
    COMPLAINT_SKU_EMPTY_ERROR(33101, "The product has been removed from the shelf, if you need to complain, please contact the platform customer service"),
    COMPLAINT_ERROR(33102, "The complaint is abnormal, please try again later"),
    COMPLAINT_NOT_EXIT(33103, "The current complaint record does not exist"),
    COMPLAINT_ARBITRATION_RESULT_ERROR(33104, "When ending an order complaint, the arbitration result cannot be empty"),
    COMPLAINT_APPEAL_CONTENT_ERROR(33105, "When a merchant appeals, the appeal content cannot be empty"),
    COMPLAINT_CANCEL_ERROR(33106, "The appeal has been completed, no need to cancel the appeal"),


    /**
     * balance
     */
    WALLET_NOT_EXIT_ERROR(34000, "The wallet does not exist, please contact the administrator"),
    WALLET_INSUFFICIENT(34001, "The balance is not enough to pay the order, please recharge!"),
    WALLET_WITHDRAWAL_INSUFFICIENT(34002, "Insufficient withdrawal amount!"),
    WALLET_WITHDRAWAL_FROZEN_AMOUNT_INSUFFICIENT(34006, "The frozen amount is not enough to process the withdrawal request!"),
    WALLET_ERROR_INSUFFICIENT(34003, "Failed to withdraw change!"),
    WALLET_REMARK_ERROR(34004, "Please fill in the review remarks!"),
    WALLET_EXIT_ERROR(34000, "The wallet already exists and cannot be created repeatedly"),
    WALLET_APPLY_ERROR(34005, "The withdrawal application is abnormal!"),

    /**
     * Evaluation
     */
    EVALUATION_DOUBLE_ERROR(35001, "Cannot submit evaluation again"),

    /**
     * Activity
     */
    PROMOTION_GOODS_NOT_EXIT(40000, "The current promotion item does not exist!"),
    PROMOTION_GOODS_QUANTITY_NOT_EXIT(40020, "The current promotion item is out of stock!"),
    PROMOTION_SAME_ACTIVE_EXIST(40001, "A similar event already exists during the event time, please choose to close or delete the event in the current time period"),
    PROMOTION_START_TIME_ERROR(40002, "Event start time cannot be less than current time"),
    PROMOTION_END_TIME_ERROR(40003, "Event end time cannot be less than current time"),
    PROMOTION_TIME_ERROR(40004, "Event start time must be greater than end time"),
    PROMOTION_TIME_NOT_EXIST(40011, "Event start time and event end time cannot be empty"),
    PROMOTION_SAME_ERROR(40005, "The same activity already exists in the current time period!"),
    PROMOTION_GOODS_ERROR(40006, "Please select a product to participate in the event"),
    PROMOTION_STATUS_END(40007, "The current activity has stopped"),
    PROMOTION_UPDATE_ERROR(40008, "The current event has started/finished and cannot be edited!"),
    PROMOTION_ACTIVITY_GOODS_ERROR(40009, "The current activity has started and cannot add goods"),
    PROMOTION_ACTIVITY_ERROR(400010, "The current promotion does not exist"),
    PROMOTION_LOG_EXIST(40011, "The event has already participated, and repeated participation has been sent"),

    /**
     * coupon
     */
    COUPON_LIMIT_ERROR(41000, "Exceeded the collection limit"),
    COUPON_EDIT_STATUS_SUCCESS(41001, "Successful status modification!"),
    COUPON_CANCELLATION_SUCCESS(41002, "Membership coupon invalid successfully"),
    COUPON_EXPIRED(41003, "Coupon has been used/expired and cannot be used"),
    COUPON_EDIT_STATUS_ERROR(41004, "Coupon modification status failed!"),
    COUPON_RECEIVE_ERROR(41005, "The current coupon has been collected, come earlier next time"),
    COUPON_NUM_INSUFFICIENT_ERROR(41006, "Insufficient number of coupons left to claim"),
    COUPON_NOT_EXIST(41007, "The current coupon does not exist"),
    COUPON_DO_NOT_RECEIVER(41030, "The current coupon is not allowed to take the initiative to claim"),
    COUPON_ACTIVITY_NOT_EXIST(410022, "The current coupon activity does not exist"),
    COUPON_SAVE_ERROR(41020, "Failed to save coupon"),
    COUPON_ACTIVITY_SAVE_ERROR(41023, "Failed to save coupon activity"),
    COUPON_DELETE_ERROR(41021, "Failed to delete coupon"),
    COUPON_LIMIT_NUM_LESS_THAN_0(41008, "The number of claim limit cannot be negative"),
    COUPON_LIMIT_GREATER_THAN_PUBLISH(41009, "The number of withdrawals exceeds the number of releases"),
    COUPON_DISCOUNT_ERROR(41010, "Coupon discount must be less than 10 and greater than 0"),
    COUPON_SCOPE_TYPE_GOODS_ERROR(41011, "When the current associated scope type is the specified item, the item list cannot be empty"),
    COUPON_SCOPE_TYPE_CATEGORY_ERROR(41012, "When the current associated scope type is a partial product category, the id associated with the scope cannot be empty"),
    COUPON_SCOPE_TYPE_STORE_ERROR(41013, "When the current associated scope type is a partial store category, the id associated with the scope cannot be empty"),
    COUPON_SCOPE_ERROR(41014, "The specified product range associated id is invalid!"),
    COUPON_MEMBER_NOT_EXIST(41015, "No current member coupon"),
    COUPON_MEMBER_STATUS_ERROR(41016, "The current membership coupon has expired/cannot be changed!"),


    /**
     * Group
     */
    PINTUAN_MANUAL_OPEN_SUCCESS(42001, "Successfully opened the group group activity manually"),
    PINTUAN_MANUAL_CLOSE_SUCCESS(42002, "Successfully closed the group activity manually"),
    PINTUAN_ADD_SUCCESS(42003, "Added group group activity successfully"),
    PINTUAN_EDIT_SUCCESS(42004, "Modify group activity successfully"),
    PINTUAN_DELETE_SUCCESS(42005, "Delete group activity successfully"),
    PINTUAN_MANUAL_OPEN_ERROR(42006, "Failed to manually open group event"),
    PINTUAN_MANUAL_CLOSE_ERROR(42007, "Failed to close the group activity manually"),
    PINTUAN_ADD_ERROR(42008, "Failed to add group activity"),
    PINTUAN_EDIT_ERROR(42009, "Failed to modify group activity"),
    PINTUAN_EDIT_ERROR_ITS_OPEN(42019, "The group activity has been opened, the group activity cannot be modified!"),
    PINTUAN_DELETE_ERROR(42010, "Failed to delete group activity"),
    PINTUAN_JOIN_ERROR(42011, "Cannot participate in the group activity initiated by yourself!"),
    PINTUAN_LIMIT_NUM_ERROR(42012, "The number of purchases exceeds the limit for group sharing activities!"),
    PINTUAN_NOT_EXIST_ERROR(42013, "The current group event does not exist!"),
    PINTUAN_GOODS_NOT_EXIST_ERROR(42014, "The current group product does not exist!"),

    /**
     * Full activity
     */
    FULL_DISCOUNT_EDIT_SUCCESS(43001, "Modify full discount activity successfully"),
    FULL_DISCOUNT_EDIT_DELETE(43002, "Delete the full discount activity successfully"),
    FULL_DISCOUNT_MODIFY_ERROR(43003, "The currently edited full discount activity has already started or ended and cannot be modified"),
    FULL_DISCOUNT_NOT_EXIST_ERROR(43004, "The current full discount activity to be operated does not exist!"),
    FULL_DISCOUNT_WAY_ERROR(43005, "Please choose a discount method!"),
    FULL_DISCOUNT_GIFT_ERROR(43006, "Please choose a gift!"),
    FULL_DISCOUNT_COUPON_TIME_ERROR(43007, "The valid time of the presented coupon must be within the event time"),
    FULL_DISCOUNT_MONEY_ERROR(43008, "Please fill in the full discount amount"),
    FULL_DISCOUNT_MONEY_GREATER_THAN_MINUS(43009, "The full discount amount cannot be greater than the discount threshold"),
    FULL_RATE_NUM_ERROR(43010, "Please fill in the discount value"),

    /**
     * live streaming
     */
    STODIO_GOODS_EXIST_ERROR(44001, "The live product already exists"),
    COMMODITY_ERROR(44002, "Failed to add live product"),

    /**
     * spike
     */
    SECKILL_NOT_START_ERROR(45000, "There is no flash sale today, please come and check it out tomorrow."),
    SECKILL_NOT_EXIST_ERROR(45001, "The current seckill activity does not exist!"),
    SECKILL_APPLY_NOT_EXIST_ERROR(45010, "The currently participating spike activity does not exist!"),
    SECKILL_UPDATE_ERROR(45002, "The current seckill activity has started and cannot be modified!"),
    SECKILL_PRICE_ERROR(45003, "The event price cannot be greater than the original price of the product"),
    SECKILL_TIME_ERROR(45004, "Time parameter is abnormal"),
    SECKILL_DELETE_ERROR(45005, "The status of this seckill activity cannot be deleted"),
    SECKILL_OPEN_ERROR(45010, "The status of this seckill activity cannot be deleted"),
    SECKILL_CLOSE_ERROR(45006, "The status of this seckill activity cannot be closed"),


    /**
     * Coupon campaign
     */
    COUPON_ACTIVITY_START_TIME_ERROR(46001, "The activity time is less than the current time and cannot be edited and deleted"),
    COUPON_ACTIVITY_MEMBER_ERROR(46002, "You must specify a member to specify precise coupon issuance, and the member cannot be empty"),
    COUPON_ACTIVITY_ITEM_ERROR(46003, "Coupon activity must specify a coupon and cannot be empty"),
    COUPON_ACTIVITY_ITEM_MUST_NUM_ERROR(46004, "Maximum 10 coupons can be specified for coupon activity"),
    COUPON_ACTIVITY_ITEM_NUM_ERROR(46005, "The number of coupons must be greater than 0"),

    /**
     * other promotions
     */
    MEMBER_SIGN_REPEAT(47001, "Do not sign in repeatedly"),
    POINT_GOODS_ACTIVE_STOCK_ERROR(47002, "The active stock quantity cannot be higher than the commodity stock"),
    POINT_GOODS_ACTIVE_STOCK_INSUFFICIENT(47003, "Insufficient stock of point goods"),

    /**
     * Bargaining activities
     */
    KANJIA_GOODS_ACTIVE_STOCK_ERROR(48001, "The active stock quantity cannot be higher than the commodity stock"),
    KANJIA_GOODS_ACTIVE_PRICE_ERROR(48002, "The minimum purchase amount cannot be higher than the item amount"),
    KANJIA_GOODS_ACTIVE_HIGHEST_PRICE_ERROR(48003, "The maximum bargaining amount cannot be 0 and cannot exceed the commodity amount"),
    KANJIA_GOODS_ACTIVE_LOWEST_PRICE_ERROR(48004, "The minimum bargaining amount cannot be 0 and cannot exceed the commodity amount"),
    KANJIA_GOODS_ACTIVE_HIGHEST_LOWEST_PRICE_ERROR(48005, "The minimum bargaining amount cannot be higher than the maximum bargaining amount"),
    KANJIA_GOODS_ACTIVE_SETTLEMENT_PRICE_ERROR(48006, "The settlement amount cannot be higher than the commodity amount"),
    KANJIA_GOODS_DELETE_ERROR(48007, "Delete bargain item abnormal"),
    KANJIA_GOODS_UPDATE_ERROR(48012, "Updating bargain items abnormal"),
    KANJIA_ACTIVITY_NOT_FOUND_ERROR(48008, "The bargaining record does not exist"),
    KANJIA_ACTIVITY_LOG_MEMBER_ERROR(48009, "The current member has already helped cut"),
    KANJIA_ACTIVITY_MEMBER_ERROR(48010, "The current member has initiated this bargaining product activity"),
    KANJIA_ACTIVITY_NOT_PASS_ERROR(48011, "The current bargaining price does not meet the conditions and cannot be purchased"),
    KANJIA_NUM_BUY_ERROR(48012, "The purchase quantity of the bargain item is incorrect"),
    /**
     * Shop
     */

    STORE_NOT_EXIST(50001, "This store does not exist"),
    STORE_NAME_EXIST_ERROR(50002, "Store name already exists!"),
    STORE_APPLY_DOUBLE_ERROR(50003, "There is already a store, no need to apply again!"),
    STORE_NOT_OPEN(50004, "The member has not opened a store"),
    STORE_NOT_LOGIN_ERROR(50005, "Not logged in store"),
    STORE_CLOSE_ERROR(50006, "The store is closed, please contact the administrator"),
    FREIGHT_TEMPLATE_NOT_EXIST(50010, "The current template does not exist"),

    /**
     * bill
     */
    BILL_CHECK_ERROR(51001, "Only the billing statement can be checked"),
    BILL_COMPLETE_ERROR(51002, "Only approved statements can be paid"),

    /**
     * article
     */
    ARTICLE_CATEGORY_NAME_EXIST(60001, "Article category name already exists"),
    ARTICLE_CATEGORY_PARENT_NOT_EXIST(60002, "Article category parent category does not exist"),
    ARTICLE_CATEGORY_BEYOND_TWO(60003, "At most a secondary category, the operation failed"),
    ARTICLE_CATEGORY_DELETE_ERROR(60004, "There are subcategories under this article category and cannot be deleted"),
    ARTICLE_CATEGORY_HAS_ARTICLE(60005, "There are articles in this article category and cannot be deleted"),
    ARTICLE_CATEGORY_NO_DELETION(60007, "The default article category cannot be deleted"),
    ARTICLE_NO_DELETION(60008, "The default article cannot be deleted"),


    /**
     * page
     */
    PAGE_NOT_EXIST(61001, "Page does not exist"),
    PAGE_OPEN_DELETE_ERROR(61002, "The current page is open and cannot be deleted"),
    PAGE_DELETE_ERROR(61003, "The current page is the only page and cannot be deleted"),
    PAGE_RELEASE_ERROR(61004, "The page has been published, no need to resubmit"),

    /**
     * set up
     */
    SETTING_NOT_TO_SET(70001, "This parameter does not need to be set"),
    ALIPAY_NOT_SETTING(70002, "Alipay payment is not configured"),
    ALIPAY_EXCEPTION(70003, "Alipay payment error, please try again later"),
    ALIPAY_PARAMS_EXCEPTION(70004, "Alipay parameter is abnormal"),
    LOGISTICS_NOT_SETTING(70005, "You have not configured express query"),
    ORDER_SETTING_ERROR(70006, "The system order configuration is abnormal"),
    ALI_SMS_SETTING_ERROR(70007, "You have not configured Alibaba Cloud SMS"),
    SMS_SIGN_EXIST_ERROR(70008, "SMS signature already exists"),

    /**
     * Station letter
     */
    NOTICE_NOT_EXIST(80001, "The current message template does not exist"),
    NOTICE_ERROR(80002, "The modification of the internal message is abnormal, please try again later"),
    NOTICE_SEND_ERROR(80003, "The sending station is abnormal, please check the system log"),


    /**
     * OSS
     */
    OSS_NOT_EXIST(80101, "OSS is not configured"),
    OSS_EXCEPTION_ERROR(80102, "File upload failed, please try again later"),
    OSS_DELETE_ERROR(80103, "Picture deletion failed"),

    /**
     * verification code
     */
    VERIFICATION_SEND_SUCCESS(80201, "SMS verification code, sent successfully"),
    VERIFICATION_ERROR(80202, "Verification failed"),
    VERIFICATION_CODE_INVALID(80204, "The verification code is invalid, please re-verify"),
    VERIFICATION_SMS_CHECKED_ERROR(80210, "The SMS verification code is incorrect, please check again"),

    /**
     * WeChat related exceptions
     */
    WECHAT_CONNECT_NOT_SETTING(80300, "Wechat joint login information is not configured"),
    WECHAT_PAYMENT_NOT_SETTING(80301, "Wechat payment information is not configured"),
    WECHAT_QRCODE_ERROR(80302, "Wechat QR code is generated abnormally"),
    WECHAT_MP_MESSAGE_ERROR(80303, "Wechat applet small message subscription exception"),
    WECHAT_JSAPI_SIGN_ERROR(80304, "Wechat JsApi signature is abnormal"),
    WECHAT_CERT_ERROR(80305, "Certificate acquisition failed"),
    WECHAT_MP_MESSAGE_TMPL_ERROR(80306, "Failed to get WeChat template message id"),
    WECHAT_ERROR(80307, "Wechat interface is abnormal"),
    APP_VERSION_EXIST(80307, "APP version already exists"),

    /**
     * other
     */
    CUSTOM_WORDS_EXIST_ERROR(90000, "The current custom word segmentation already exists!"),
    CUSTOM_WORDS_NOT_EXIST_ERROR(90001, "The current custom word segmentation does not exist!"),
    CUSTOM_WORDS_SECRET_KEY_ERROR(90002, "Secret key verification failed!"),
    CONNECT_NOT_EXIST(90000, "The login method does not exist!"),
    ELASTICSEARCH_INDEX_INIT_ERROR(90003, "Index initialization failed!"),
    PURCHASE_ORDER_DEADLINE_ERROR(90004, "The supply and demand order has exceeded the registration deadline"),
    INDEX_BUILDING(90005, "Index is being built");

    private final Integer code;
    private final String message;


    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

}
