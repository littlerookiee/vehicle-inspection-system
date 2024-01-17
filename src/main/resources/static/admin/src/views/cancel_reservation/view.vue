<template>
	<el-main class="bg edit_wrap comtable_e">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">
		<el-row class="row_ce"> 
							<el-col v-if="user_group === '管理员' || $check_field('get','car_owner_account') || $check_field('add','car_owner_account') || $check_field('set','car_owner_account')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="车主账号" prop="car_owner_account">
																		<div v-if="user_group !== '管理员'">
							{{ get_user_session_car_owner_account(form['car_owner_account']) }}
							<!--<el-input id="business_name" v-model="form['car_owner_account']" placeholder="请输入车主账号"-->
							<!--v-if="user_group === '管理员' || (form['cancel_reservation_id'] && $check_field('set','car_owner_account')) || (!form['cancel_reservation_id'] && $check_field('add','car_owner_account'))" :disabled="disabledObj['car_owner_account_isDisabled']"></el-input>-->
							<!--<div v-else-if="$check_field('get','car_owner_account')">{{form['car_owner_account']}}</div>-->
							<el-select v-if="user_group === '管理员' || (form['cancel_reservation_id'] && $check_field('set','car_owner_account')) || (!form['cancel_reservation_id'] && $check_field('add','car_owner_account'))" id="car_owner_account" v-model="form['car_owner_account']" :disabled="disabledObj['car_owner_account_isDisabled']">
								<el-option v-for="o in list_user_car_owner_account" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
							<el-select v-else-if="$check_field('get','car_owner_account')" id="car_owner_account" v-model="form['car_owner_account']" :disabled="true">
								<el-option v-for="o in list_user_car_owner_account" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
						</div>
						<el-select v-else id="car_owner_account" v-model="form['car_owner_account']" :disabled="disabledObj['car_owner_account_isDisabled']">
							<el-option v-for="o in list_user_car_owner_account" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
																</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','owners_name') || $check_field('add','owners_name') || $check_field('set','owners_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="车主姓名" prop="owners_name">
												<el-input id="owners_name" v-model="form['owners_name']" placeholder="请输入车主姓名"
							  v-if="user_group === '管理员' || (form['cancel_reservation_id'] && $check_field('set','owners_name')) || (!form['cancel_reservation_id'] && $check_field('add','owners_name'))" :disabled="disabledObj['owners_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','owners_name')">{{form['owners_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','vehicle_owner_gender') || $check_field('add','vehicle_owner_gender') || $check_field('set','vehicle_owner_gender')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="车主性别" prop="vehicle_owner_gender">
												<el-input id="vehicle_owner_gender" v-model="form['vehicle_owner_gender']" placeholder="请输入车主性别"
							  v-if="user_group === '管理员' || (form['cancel_reservation_id'] && $check_field('set','vehicle_owner_gender')) || (!form['cancel_reservation_id'] && $check_field('add','vehicle_owner_gender'))" :disabled="disabledObj['vehicle_owner_gender_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','vehicle_owner_gender')">{{form['vehicle_owner_gender']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','car_owners_phone_number') || $check_field('add','car_owners_phone_number') || $check_field('set','car_owners_phone_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="车主电话" prop="car_owners_phone_number">
												<el-input id="car_owners_phone_number" v-model="form['car_owners_phone_number']" placeholder="请输入车主电话"
							  v-if="user_group === '管理员' || (form['cancel_reservation_id'] && $check_field('set','car_owners_phone_number')) || (!form['cancel_reservation_id'] && $check_field('add','car_owners_phone_number'))" :disabled="disabledObj['car_owners_phone_number_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','car_owners_phone_number')">{{form['car_owners_phone_number']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','id_number') || $check_field('add','id_number') || $check_field('set','id_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="身份证号" prop="id_number">
												<el-input id="id_number" v-model="form['id_number']" placeholder="请输入身份证号"
							  v-if="user_group === '管理员' || (form['cancel_reservation_id'] && $check_field('set','id_number')) || (!form['cancel_reservation_id'] && $check_field('add','id_number'))" :disabled="disabledObj['id_number_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','id_number')">{{form['id_number']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','vehicle_model') || $check_field('add','vehicle_model') || $check_field('set','vehicle_model')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="车辆车型" prop="vehicle_model">
												<el-input id="vehicle_model" v-model="form['vehicle_model']" placeholder="请输入车辆车型"
							  v-if="user_group === '管理员' || (form['cancel_reservation_id'] && $check_field('set','vehicle_model')) || (!form['cancel_reservation_id'] && $check_field('add','vehicle_model'))" :disabled="disabledObj['vehicle_model_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','vehicle_model')">{{form['vehicle_model']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','license_plate_number') || $check_field('add','license_plate_number') || $check_field('set','license_plate_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="车牌号码" prop="license_plate_number">
												<el-input id="license_plate_number" v-model="form['license_plate_number']" placeholder="请输入车牌号码"
							  v-if="user_group === '管理员' || (form['cancel_reservation_id'] && $check_field('set','license_plate_number')) || (!form['cancel_reservation_id'] && $check_field('add','license_plate_number'))" :disabled="disabledObj['license_plate_number_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','license_plate_number')">{{form['license_plate_number']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','store_name') || $check_field('add','store_name') || $check_field('set','store_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="店铺名称" prop="store_name">
												<el-input id="store_name" v-model="form['store_name']" placeholder="请输入店铺名称"
							  v-if="user_group === '管理员' || (form['cancel_reservation_id'] && $check_field('set','store_name')) || (!form['cancel_reservation_id'] && $check_field('add','store_name'))" :disabled="disabledObj['store_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','store_name')">{{form['store_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','detection_address') || $check_field('add','detection_address') || $check_field('set','detection_address')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="检测地址" prop="detection_address">
												<el-input id="detection_address" v-model="form['detection_address']" placeholder="请输入检测地址"
							  v-if="user_group === '管理员' || (form['cancel_reservation_id'] && $check_field('set','detection_address')) || (!form['cancel_reservation_id'] && $check_field('add','detection_address'))" :disabled="disabledObj['detection_address_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','detection_address')">{{form['detection_address']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','available_time_for_scheduling') || $check_field('add','available_time_for_scheduling') || $check_field('set','available_time_for_scheduling')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="可约时间" prop="available_time_for_scheduling">
								<el-date-picker :disabled="disabledObj['available_time_for_scheduling_isDisabled']" v-if="user_group === '管理员' || (form['cancel_reservation_id'] && $check_field('set','available_time_for_scheduling')) || (!form['cancel_reservation_id'] && $check_field('add','available_time_for_scheduling'))" id="available_time_for_scheduling"
						v-model="form['available_time_for_scheduling']" type="datetime" placeholder="选择日期时间">
					</el-date-picker>
					<div v-else-if="$check_field('get','available_time_for_scheduling')">{{form['available_time_for_scheduling']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','testing_prices') || $check_field('add','testing_prices') || $check_field('set','testing_prices')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="检测价格" prop="testing_prices">
								<el-input-number id="testing_prices" v-model.number="form['testing_prices']"
						v-if="user_group === '管理员' || (form['cancel_reservation_id'] && $check_field('set','testing_prices')) || (!form['cancel_reservation_id'] && $check_field('add','testing_prices'))" :disabled="disabledObj['testing_prices_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','testing_prices')">{{form['testing_prices']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','appointment_time') || $check_field('add','appointment_time') || $check_field('set','appointment_time')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="预约时间" prop="appointment_time">
								<el-date-picker :disabled="disabledObj['appointment_time_isDisabled']" v-if="user_group === '管理员' || (form['cancel_reservation_id'] && $check_field('set','appointment_time')) || (!form['cancel_reservation_id'] && $check_field('add','appointment_time'))" id="appointment_time"
						v-model="form['appointment_time']" type="datetime" placeholder="选择日期时间">
					</el-date-picker>
					<div v-else-if="$check_field('get','appointment_time')">{{form['appointment_time']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','detection_content') || $check_field('add','detection_content') || $check_field('set','detection_content')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="检测内容" prop="detection_content">
												<el-input id="detection_content" v-model="form['detection_content']" placeholder="请输入检测内容"
							  v-if="user_group === '管理员' || (form['cancel_reservation_id'] && $check_field('set','detection_content')) || (!form['cancel_reservation_id'] && $check_field('add','detection_content'))" :disabled="disabledObj['detection_content_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','detection_content')">{{form['detection_content']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','order_number') || $check_field('add','order_number') || $check_field('set','order_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="订单编号" prop="order_number">
												<el-input id="order_number" v-model="form['order_number']" placeholder="请输入订单编号"
							  v-if="user_group === '管理员' || (form['cancel_reservation_id'] && $check_field('set','order_number')) || (!form['cancel_reservation_id'] && $check_field('add','order_number'))" :disabled="disabledObj['order_number_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','order_number')">{{form['order_number']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','cancel_time') || $check_field('add','cancel_time') || $check_field('set','cancel_time')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="取消时间" prop="cancel_time">
								<el-date-picker :disabled="disabledObj['cancel_time_isDisabled']" v-if="user_group === '管理员' || (form['cancel_reservation_id'] && $check_field('set','cancel_time')) || (!form['cancel_reservation_id'] && $check_field('add','cancel_time'))" id="cancel_time"
						v-model="form['cancel_time']" type="datetime" placeholder="选择日期时间">
					</el-date-picker>
					<div v-else-if="$check_field('get','cancel_time')">{{form['cancel_time']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','reason_for_cancellation') || $check_field('add','reason_for_cancellation') || $check_field('set','reason_for_cancellation')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="取消原因" prop="reason_for_cancellation">
								<el-input type="textarea" id="reason_for_cancellation" v-model="form['reason_for_cancellation']" placeholder="请输入取消原因"
						v-if="user_group === '管理员' || (form['cancel_reservation_id'] && $check_field('set','reason_for_cancellation')) || (!form['cancel_reservation_id'] && $check_field('add','reason_for_cancellation'))" :disabled="disabledObj['reason_for_cancellation_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','reason_for_cancellation')">{{form['reason_for_cancellation']}}</div>
							</el-form-item>
			</el-col>
							<el-col :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="审核状态" prop="examine_state">
					<el-select id="examine_state" v-model="form['examine_state']"
						v-if="user_group === '管理员' || (form['examine_state'] && $check_examine()) || (!form['examine_state'] && $check_examine())">
						<el-option key="未审核" label="未审核" value="未审核"></el-option>
						<el-option key="已通过" label="已通过" value="已通过"></el-option>
						<el-option key="未通过" label="未通过" value="未通过"></el-option>
					</el-select>
					<div v-else>{{form["examine_state"]}}</div>
				</el-form-item>
			</el-col>
					<el-col :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="审核回复" prop="examine_reply">
					<el-input id="examine_reply" v-model="form['examine_reply']" placeholder="请输入审核回复"
						v-if="user_group === '管理员' || (form['examine_reply'] && $check_examine()) || (!form['examine_reply'] && $check_examine())"></el-input>
					<div v-else>{{form["examine_reply"]}}</div>
				</el-form-item>
			</el-col>
	
	
	
	
	
	
	
		</el-row>
			<el-col :xs="24" :sm="12" :lg="8" class="el_form_btn_warp">
				<el-form-item v-if="$check_action('/cancel_reservation/view','set') || $check_action('/cancel_reservation/view','add') || $check_option('/cancel_reservation/table','examine')">
					<el-button type="primary" @click="submit()">提交</el-button>
					<el-button @click="cancel()">取消</el-button>
				</el-form-item>
				<el-form-item v-else>
					<el-button @click="cancel()">返回</el-button>
				</el-form-item>
			</el-col>

		</el-form>
	</el-main>
</template>

<script>
	import mixin from "@/mixins/page.js";

	export default {
		mixins: [mixin],
		data() {
			return {
				field: "cancel_reservation_id",
				url_add: "~/api/cancel_reservation/add?",
				url_set: "~/api/cancel_reservation/set?",
				url_get_obj: "~/api/cancel_reservation/get_obj?",
				url_upload: "~/api/cancel_reservation/upload?",

				query: {
					"cancel_reservation_id": 0,
				},

				form: {
								"car_owner_account": 0, // 车主账号
										"owners_name":  '', // 车主姓名
										"vehicle_owner_gender":  '', // 车主性别
										"car_owners_phone_number":  '', // 车主电话
										"id_number":  '', // 身份证号
										"vehicle_model":  '', // 车辆车型
										"license_plate_number":  '', // 车牌号码
										"store_name":  '', // 店铺名称
										"detection_address":  '', // 检测地址
										"available_time_for_scheduling":  '', // 可约时间
										"testing_prices":  0, // 检测价格
										"appointment_time":  '', // 预约时间
										"detection_content":  '', // 检测内容
										"order_number":  '', // 订单编号
										"cancel_time":  '', // 取消时间
										"reason_for_cancellation":  '', // 取消原因
									"examine_state": "未审核",
							"examine_reply": "",
							"cancel_reservation_id": 0, // ID
						
				},
				disabledObj:{
								"car_owner_account_isDisabled": false,
										"owners_name_isDisabled": false,
										"vehicle_owner_gender_isDisabled": false,
										"car_owners_phone_number_isDisabled": false,
										"id_number_isDisabled": false,
										"vehicle_model_isDisabled": false,
										"license_plate_number_isDisabled": false,
										"store_name_isDisabled": false,
										"detection_address_isDisabled": false,
										"available_time_for_scheduling_isDisabled": false,
					          			"testing_prices_isDisabled": false,
										"appointment_time_isDisabled": false,
										"detection_content_isDisabled": false,
										"order_number_isDisabled": false,
										"cancel_time_isDisabled": false,
										"reason_for_cancellation_isDisabled": false,
										},

	
					// 用户列表
				list_user_car_owner_account: [],
						// 用户组
				group_user_car_owner_account: "",
				
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
			}
		},
		methods: {


	
	
				/**
			 * 获取车主用户用户列表
			 */
			async get_list_user_car_owner_account() {
                // if(this.user_group !== "管理员" && this.form["car_owner_account"] === 0) {
                //     this.form["car_owner_account"] = this.user.user_id;
                // }
                var json = await this.$get("~/api/user/get_list?user_group=车主用户");
                if(json.result && json.result.list){
                    this.list_user_car_owner_account = json.result.list;
                }
                else if(json.error){
                    console.error(json.error);
                }
			},
					/**
			 * 获取车主用户用户组
			 */
			async get_group_user_car_owner_account() {
							this.form["car_owner_account"] = this.user.user_id;
							var json = await this.$get("~/api/user_group/get_obj?name=车主用户");
				if(json.result && json.result.obj){
					this.group_user_car_owner_account = json.result.obj;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
			get_user_session_car_owner_account(id){
				var _this = this;
				var user_id = {"user_id":id}
				var url = "~/api/"+_this.group_user_car_owner_account.source_table+"/get_obj?"
				this.$get(url, user_id, function(res) {
					if (res.result && res.result.obj) {
						var arr = []
						for (let key in res.result.obj) {
							arr.push(key)
						}
						var arrForm = []
									for (let key in _this.form) {
							arrForm.push(key)
						}
												_this.form["car_owner_account"] = id
									_this.disabledObj['car_owner_account' + '_isDisabled'] = true
						for (var i=0;i<arr.length;i++){
						  if (arr[i]!=='examine_state' && arr[i]!=='examine_reply') {
							for (var j = 0; j < arrForm.length; j++) {
							  if (arr[i] === arrForm[j]) {
								if (arr[i] !== "car_owner_account") {
			                      _this.form[arrForm[j]] = res.result.obj[arr[i]]
			                      _this.disabledObj[arrForm[j] + '_isDisabled'] = true
								  break;
								} else {
								  _this.disabledObj[arrForm[j] + '_isDisabled'] = true
								}
							  }
							}
						  }
						}
					}
				});
			},
					get_user_car_owner_account(id){
				var obj = this.list_user_car_owner_account.getObj({"user_id":id});
				var ret = "";
				if(obj){
					if(obj.nickname){
						ret = obj.nickname;}
					else{
						ret = obj.username;
					}
				}
				return ret;
			},
			
	
			
	
			
	
			
	
			
	
			
	
			
	
			
	
			
	
			
	
			
	
			
	
			
	
			
	
			
	
		
			/**
			 * 获取对象之前
			 * @param {Object} param
			 */
			get_obj_before(param) {
				var form = "";
																			// 获取缓存数据附加
				form = $.db.get("form");
							$.push(this.form ,form);
												
				if(this.form && form){
					Object.keys(this.form).forEach(key => {
						Object.keys(form).forEach(dbKey => {
							// if(dbKey === "charging_standard"){
							// 	this.form['charging_rules'] = form[dbKey];
							// 	this.disabledObj['charging_rules_isDisabled'] = true;
							// };
							if(key === dbKey){
								this.disabledObj[key+'_isDisabled'] = true;
							}
						})
					})
				}
																			        if (this.form["available_time_for_scheduling"] && this.form["available_time_for_scheduling"].indexOf("-")===-1){
            this.form["available_time_for_scheduling"] = this.$toTime(parseInt(this.form["available_time_for_scheduling"]),"yyyy-MM-dd hh:mm:ss")
        }
					        if (this.form["appointment_time"] && this.form["appointment_time"].indexOf("-")===-1){
            this.form["appointment_time"] = this.$toTime(parseInt(this.form["appointment_time"]),"yyyy-MM-dd hh:mm:ss")
        }
							        if (this.form["cancel_time"] && this.form["cancel_time"].indexOf("-")===-1){
            this.form["cancel_time"] = this.$toTime(parseInt(this.form["cancel_time"]),"yyyy-MM-dd hh:mm:ss")
        }
								$.db.del("form");

				return param;
			},

			/**
			 * 获取对象之后
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_after(json, func){
																																									if(this.form["available_time_for_scheduling"]=="0000-00-00 00:00:00"){
				  this.form["available_time_for_scheduling"] = null;
				}
				if(parseInt(this.form["available_time_for_scheduling"]) > 9999){
					this.form["available_time_for_scheduling"] = this.$toTime(parseInt(this.form["available_time_for_scheduling"]),"yyyy-MM-dd hh:mm:ss")
				}
													if(this.form["appointment_time"]=="0000-00-00 00:00:00"){
				  this.form["appointment_time"] = null;
				}
				if(parseInt(this.form["appointment_time"]) > 9999){
					this.form["appointment_time"] = this.$toTime(parseInt(this.form["appointment_time"]),"yyyy-MM-dd hh:mm:ss")
				}
																	if(this.form["cancel_time"]=="0000-00-00 00:00:00"){
				  this.form["cancel_time"] = null;
				}
				if(parseInt(this.form["cancel_time"]) > 9999){
					this.form["cancel_time"] = this.$toTime(parseInt(this.form["cancel_time"]),"yyyy-MM-dd hh:mm:ss")
				}
								

			},

			/**
			 * 提交前验证事件
			 * @param {Object} 请求参数
			 * @return {String} 验证成功返回null, 失败返回错误提示
			 */
			submit_check(param) {
																																																																																																																																																						return null;
			},

			is_view(){
				var bl = this.user_group == "管理员";

				if(!bl){
					bl = this.$check_action('/cancel_reservation/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/cancel_reservation/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/cancel_reservation/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/cancel_reservation/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/cancel_reservation/view','get');
					console.log(bl ? "你有视图查询权限视作有查询权限" : "你没有视图查询权限");
				}

				console.log(bl ? "具有当前页面的查看权，请注意这不代表你有字段的查看权" : "无权查看当前页，请注意即便有字段查询权限没有页面查询权限也不行");

				return bl;
			},
			/**
			 * 上传文件
			 * @param {Object} param
			 */
			uploadimg(param) {
				this.uploadFile(param.file, "avatar");
			},

		},
		created() {
					this.get_list_user_car_owner_account();
					this.get_group_user_car_owner_account();
																																			},
	}
</script>

<style>
	.avatar-uploader .el-upload {
		border: 1px dashed #d9d9d9;
		border-radius: 6px;
		cursor: pointer;
		position: relative;
		overflow: hidden;
	}

	.avatar-uploader .el-upload:hover {
		border-color: #409EFF;
	}

	.avatar-uploader-icon {
		font-size: 28px;
		color: #8c939d;
		width: 178px;
		height: 178px;
		line-height: 178px;
		text-align: center;
	}

	.avatar {
		width: 178px;
		height: 178px;
		display: block;
	}




</style>
