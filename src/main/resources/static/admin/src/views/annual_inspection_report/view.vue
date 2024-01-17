<template>
	<el-main class="bg edit_wrap comtable_e">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">
		<el-row class="row_ce"> 
							<el-col v-if="user_group === '管理员' || $check_field('get','detect_account') || $check_field('add','detect_account') || $check_field('set','detect_account')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="检测账号" prop="detect_account">
																		<div v-if="user_group !== '管理员'">
							{{ get_user_session_detect_account(form['detect_account']) }}
							<!--<el-input id="business_name" v-model="form['detect_account']" placeholder="请输入检测账号"-->
							<!--v-if="user_group === '管理员' || (form['annual_inspection_report_id'] && $check_field('set','detect_account')) || (!form['annual_inspection_report_id'] && $check_field('add','detect_account'))" :disabled="disabledObj['detect_account_isDisabled']"></el-input>-->
							<!--<div v-else-if="$check_field('get','detect_account')">{{form['detect_account']}}</div>-->
							<el-select v-if="user_group === '管理员' || (form['annual_inspection_report_id'] && $check_field('set','detect_account')) || (!form['annual_inspection_report_id'] && $check_field('add','detect_account'))" id="detect_account" v-model="form['detect_account']" :disabled="disabledObj['detect_account_isDisabled']">
								<el-option v-for="o in list_user_detect_account" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
							<el-select v-else-if="$check_field('get','detect_account')" id="detect_account" v-model="form['detect_account']" :disabled="true">
								<el-option v-for="o in list_user_detect_account" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
						</div>
						<el-select v-else id="detect_account" v-model="form['detect_account']" :disabled="disabledObj['detect_account_isDisabled']">
							<el-option v-for="o in list_user_detect_account" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
																</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','user_name') || $check_field('add','user_name') || $check_field('set','user_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="用户姓名" prop="user_name">
												<el-input id="user_name" v-model="form['user_name']" placeholder="请输入用户姓名"
							  v-if="user_group === '管理员' || (form['annual_inspection_report_id'] && $check_field('set','user_name')) || (!form['annual_inspection_report_id'] && $check_field('add','user_name'))" :disabled="disabledObj['user_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','user_name')">{{form['user_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','car_owner_account') || $check_field('add','car_owner_account') || $check_field('set','car_owner_account')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="车主账号" prop="car_owner_account">
													<el-select v-if="user_group === '管理员' || (form['annual_inspection_report_id'] && $check_field('set','car_owner_account')) || (!form['annual_inspection_report_id'] && $check_field('add','car_owner_account'))" id="car_owner_account" v-model="form['car_owner_account']" :disabled="disabledObj['car_owner_account_isDisabled']">
							<el-option v-for="o in list_user_car_owner_account" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
						<el-select v-else-if="$check_field('get','car_owner_account')" id="car_owner_account" v-model="form['car_owner_account']" :disabled="true">
							<el-option v-for="o in list_user_car_owner_account" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','owners_name') || $check_field('add','owners_name') || $check_field('set','owners_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="车主姓名" prop="owners_name">
												<el-input id="owners_name" v-model="form['owners_name']" placeholder="请输入车主姓名"
							  v-if="user_group === '管理员' || (form['annual_inspection_report_id'] && $check_field('set','owners_name')) || (!form['annual_inspection_report_id'] && $check_field('add','owners_name'))" :disabled="disabledObj['owners_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','owners_name')">{{form['owners_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','vehicle_owner_gender') || $check_field('add','vehicle_owner_gender') || $check_field('set','vehicle_owner_gender')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="车主性别" prop="vehicle_owner_gender">
												<el-input id="vehicle_owner_gender" v-model="form['vehicle_owner_gender']" placeholder="请输入车主性别"
							  v-if="user_group === '管理员' || (form['annual_inspection_report_id'] && $check_field('set','vehicle_owner_gender')) || (!form['annual_inspection_report_id'] && $check_field('add','vehicle_owner_gender'))" :disabled="disabledObj['vehicle_owner_gender_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','vehicle_owner_gender')">{{form['vehicle_owner_gender']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','car_owners_phone_number') || $check_field('add','car_owners_phone_number') || $check_field('set','car_owners_phone_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="车主电话" prop="car_owners_phone_number">
												<el-input id="car_owners_phone_number" v-model="form['car_owners_phone_number']" placeholder="请输入车主电话"
							  v-if="user_group === '管理员' || (form['annual_inspection_report_id'] && $check_field('set','car_owners_phone_number')) || (!form['annual_inspection_report_id'] && $check_field('add','car_owners_phone_number'))" :disabled="disabledObj['car_owners_phone_number_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','car_owners_phone_number')">{{form['car_owners_phone_number']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','id_number') || $check_field('add','id_number') || $check_field('set','id_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="身份证号" prop="id_number">
												<el-input id="id_number" v-model="form['id_number']" placeholder="请输入身份证号"
							  v-if="user_group === '管理员' || (form['annual_inspection_report_id'] && $check_field('set','id_number')) || (!form['annual_inspection_report_id'] && $check_field('add','id_number'))" :disabled="disabledObj['id_number_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','id_number')">{{form['id_number']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','vehicle_model') || $check_field('add','vehicle_model') || $check_field('set','vehicle_model')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="车辆车型" prop="vehicle_model">
												<el-input id="vehicle_model" v-model="form['vehicle_model']" placeholder="请输入车辆车型"
							  v-if="user_group === '管理员' || (form['annual_inspection_report_id'] && $check_field('set','vehicle_model')) || (!form['annual_inspection_report_id'] && $check_field('add','vehicle_model'))" :disabled="disabledObj['vehicle_model_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','vehicle_model')">{{form['vehicle_model']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','license_plate_number') || $check_field('add','license_plate_number') || $check_field('set','license_plate_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="车牌号码" prop="license_plate_number">
												<el-input id="license_plate_number" v-model="form['license_plate_number']" placeholder="请输入车牌号码"
							  v-if="user_group === '管理员' || (form['annual_inspection_report_id'] && $check_field('set','license_plate_number')) || (!form['annual_inspection_report_id'] && $check_field('add','license_plate_number'))" :disabled="disabledObj['license_plate_number_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','license_plate_number')">{{form['license_plate_number']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','store_name') || $check_field('add','store_name') || $check_field('set','store_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="店铺名称" prop="store_name">
												<el-input id="store_name" v-model="form['store_name']" placeholder="请输入店铺名称"
							  v-if="user_group === '管理员' || (form['annual_inspection_report_id'] && $check_field('set','store_name')) || (!form['annual_inspection_report_id'] && $check_field('add','store_name'))" :disabled="disabledObj['store_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','store_name')">{{form['store_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','detection_address') || $check_field('add','detection_address') || $check_field('set','detection_address')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="检测地址" prop="detection_address">
												<el-input id="detection_address" v-model="form['detection_address']" placeholder="请输入检测地址"
							  v-if="user_group === '管理员' || (form['annual_inspection_report_id'] && $check_field('set','detection_address')) || (!form['annual_inspection_report_id'] && $check_field('add','detection_address'))" :disabled="disabledObj['detection_address_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','detection_address')">{{form['detection_address']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','available_time_for_scheduling') || $check_field('add','available_time_for_scheduling') || $check_field('set','available_time_for_scheduling')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="可约时间" prop="available_time_for_scheduling">
								<el-date-picker :disabled="disabledObj['available_time_for_scheduling_isDisabled']" v-if="user_group === '管理员' || (form['annual_inspection_report_id'] && $check_field('set','available_time_for_scheduling')) || (!form['annual_inspection_report_id'] && $check_field('add','available_time_for_scheduling'))" id="available_time_for_scheduling"
						v-model="form['available_time_for_scheduling']" type="datetime" placeholder="选择日期时间">
					</el-date-picker>
					<div v-else-if="$check_field('get','available_time_for_scheduling')">{{form['available_time_for_scheduling']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','testing_prices') || $check_field('add','testing_prices') || $check_field('set','testing_prices')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="检测价格" prop="testing_prices">
								<el-input-number id="testing_prices" v-model.number="form['testing_prices']"
						v-if="user_group === '管理员' || (form['annual_inspection_report_id'] && $check_field('set','testing_prices')) || (!form['annual_inspection_report_id'] && $check_field('add','testing_prices'))" :disabled="disabledObj['testing_prices_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','testing_prices')">{{form['testing_prices']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','appointment_time') || $check_field('add','appointment_time') || $check_field('set','appointment_time')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="预约时间" prop="appointment_time">
								<el-date-picker :disabled="disabledObj['appointment_time_isDisabled']" v-if="user_group === '管理员' || (form['annual_inspection_report_id'] && $check_field('set','appointment_time')) || (!form['annual_inspection_report_id'] && $check_field('add','appointment_time'))" id="appointment_time"
						v-model="form['appointment_time']" type="datetime" placeholder="选择日期时间">
					</el-date-picker>
					<div v-else-if="$check_field('get','appointment_time')">{{form['appointment_time']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','detection_content') || $check_field('add','detection_content') || $check_field('set','detection_content')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="检测内容" prop="detection_content">
												<el-input id="detection_content" v-model="form['detection_content']" placeholder="请输入检测内容"
							  v-if="user_group === '管理员' || (form['annual_inspection_report_id'] && $check_field('set','detection_content')) || (!form['annual_inspection_report_id'] && $check_field('add','detection_content'))" :disabled="disabledObj['detection_content_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','detection_content')">{{form['detection_content']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','order_number') || $check_field('add','order_number') || $check_field('set','order_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="订单编号" prop="order_number">
												<el-input id="order_number" v-model="form['order_number']" placeholder="请输入订单编号"
							  v-if="user_group === '管理员' || (form['annual_inspection_report_id'] && $check_field('set','order_number')) || (!form['annual_inspection_report_id'] && $check_field('add','order_number'))" :disabled="disabledObj['order_number_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','order_number')">{{form['order_number']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','annual_inspection_date') || $check_field('add','annual_inspection_date') || $check_field('set','annual_inspection_date')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="年检日期" prop="annual_inspection_date">
								<el-date-picker :disabled="disabledObj['annual_inspection_date_isDisabled']" v-if="user_group === '管理员' || (form['annual_inspection_report_id'] && $check_field('set','annual_inspection_date')) || (!form['annual_inspection_report_id'] && $check_field('add','annual_inspection_date'))" id="annual_inspection_date"
						v-model="form['annual_inspection_date']" type="date" placeholder="选择日期">
					</el-date-picker>
					<div v-else-if="$check_field('get','annual_inspection_date')">{{form['annual_inspection_date']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','next_annual_inspection') || $check_field('add','next_annual_inspection') || $check_field('set','next_annual_inspection')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="下次年检" prop="next_annual_inspection">
								<el-date-picker :disabled="disabledObj['next_annual_inspection_isDisabled']" v-if="user_group === '管理员' || (form['annual_inspection_report_id'] && $check_field('set','next_annual_inspection')) || (!form['annual_inspection_report_id'] && $check_field('add','next_annual_inspection'))" id="next_annual_inspection"
						v-model="form['next_annual_inspection']" type="date" placeholder="选择日期">
					</el-date-picker>
					<div v-else-if="$check_field('get','next_annual_inspection')">{{form['next_annual_inspection']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','annual_inspection_report') || $check_field('add','annual_inspection_report') || $check_field('set','annual_inspection_report')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="年检报告" prop="annual_inspection_report">
												<div v-if="disabledObj['annual_inspection_report_isDisabled']">
						<div v-if="$check_field('get','annual_inspection_report')">
							<el-button type="primary" @click="$download($fullUrl(form['annual_inspection_report']),form['annual_inspection_report'])">下载<i
									class="el-icon-download el-icon--right"></i></el-button>
						</div>
					</div>
					<div v-else>
						<el-upload v-if="user_group === '管理员' || (form['annual_inspection_report_id'] && $check_field('set','annual_inspection_report')) || (!form['annual_inspection_report_id'] && $check_field('add','annual_inspection_report'))" class="upload-demo" drag
								   action="" style="max-width: 300px;width: 100%;" :http-request="upload_annual_inspection_report" :limit="1" accept="">
							<i class="el-icon-upload"></i>
							<div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
						</el-upload>
						<div v-else-if="$check_field('get','annual_inspection_report')">
							<el-button type="primary" @click="$download($fullUrl(form['annual_inspection_report']),form['annual_inspection_report'])">下载<i
									class="el-icon-download el-icon--right"></i></el-button>
						</div>
					</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','annual_inspection_status') || $check_field('add','annual_inspection_status') || $check_field('set','annual_inspection_status')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="年检状态" prop="annual_inspection_status">
								<el-select id="annual_inspection_status" v-model="form['annual_inspection_status']"
						v-if="user_group === '管理员' || (form['annual_inspection_report_id'] && $check_field('set','annual_inspection_status')) || (!form['annual_inspection_report_id'] && $check_field('add','annual_inspection_status'))">
						<el-option v-for="o in list_annual_inspection_status" :key="o" :label="o" :value="o">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','annual_inspection_status')">{{form['annual_inspection_status']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','annual_inspection_results') || $check_field('add','annual_inspection_results') || $check_field('set','annual_inspection_results')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="年检结果" prop="annual_inspection_results">
								<el-input type="textarea" id="annual_inspection_results" v-model="form['annual_inspection_results']" placeholder="请输入年检结果"
						v-if="user_group === '管理员' || (form['annual_inspection_report_id'] && $check_field('set','annual_inspection_results')) || (!form['annual_inspection_report_id'] && $check_field('add','annual_inspection_results'))" :disabled="disabledObj['annual_inspection_results_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','annual_inspection_results')">{{form['annual_inspection_results']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','annual_inspection_records') || $check_field('add','annual_inspection_records') || $check_field('set','annual_inspection_records')" :xs="24" :sm="24" :lg="24" class="el_form_editor_warp">
				<el-form-item label="年检记录" prop="annual_inspection_records">
					<quill-editor v-model.number="form['annual_inspection_records']"
						v-if="user_group === '管理员' || (form['annual_inspection_report_id'] && $check_field('set','annual_inspection_records')) || (!form['annual_inspection_report_id'] && $check_field('add','annual_inspection_records')) ">
					</quill-editor>
					<div v-else-if="$check_field('get','annual_inspection_records')" v-html="form['annual_inspection_records']"></div>
				</el-form-item>
			</el-col>
					
	
	
	
	
	
	
		</el-row>
			<el-col :xs="24" :sm="12" :lg="8" class="el_form_btn_warp">
				<el-form-item v-if="$check_action('/annual_inspection_report/view','set') || $check_action('/annual_inspection_report/view','add') || $check_option('/annual_inspection_report/table','examine')">
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
				field: "annual_inspection_report_id",
				url_add: "~/api/annual_inspection_report/add?",
				url_set: "~/api/annual_inspection_report/set?",
				url_get_obj: "~/api/annual_inspection_report/get_obj?",
				url_upload: "~/api/annual_inspection_report/upload?",

				query: {
					"annual_inspection_report_id": 0,
				},

				form: {
								"detect_account": 0, // 检测账号
										"user_name":  '', // 用户姓名
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
										"annual_inspection_date":  '', // 年检日期
										"next_annual_inspection":  '', // 下次年检
										"annual_inspection_report":  '', // 年检报告
										"annual_inspection_status":  '', // 年检状态
										"annual_inspection_results":  '', // 年检结果
										"annual_inspection_records":  '', // 年检记录
											"annual_inspection_report_id": 0, // ID
						
				},
				disabledObj:{
								"detect_account_isDisabled": false,
										"user_name_isDisabled": false,
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
										"annual_inspection_date_isDisabled": false,
										"next_annual_inspection_isDisabled": false,
										"annual_inspection_report_isDisabled": false,
										"annual_inspection_status_isDisabled": false,
										"annual_inspection_results_isDisabled": false,
										"annual_inspection_records_isDisabled": false,
										},

	
					// 用户列表
				list_user_detect_account: [],
						// 用户组
				group_user_detect_account: "",
				
		
					// 用户列表
				list_user_car_owner_account: [],
				
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
								// 年检状态选项列表
				list_annual_inspection_status: ['已通过','未通过'],
	
		
		
	
			}
		},
		methods: {


	
	
				/**
			 * 获取检测用户用户列表
			 */
			async get_list_user_detect_account() {
                // if(this.user_group !== "管理员" && this.form["detect_account"] === 0) {
                //     this.form["detect_account"] = this.user.user_id;
                // }
                var json = await this.$get("~/api/user/get_list?user_group=检测用户");
                if(json.result && json.result.list){
                    this.list_user_detect_account = json.result.list;
                }
                else if(json.error){
                    console.error(json.error);
                }
			},
					/**
			 * 获取检测用户用户组
			 */
			async get_group_user_detect_account() {
							this.form["detect_account"] = this.user.user_id;
							var json = await this.$get("~/api/user_group/get_obj?name=检测用户");
				if(json.result && json.result.obj){
					this.group_user_detect_account = json.result.obj;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
			get_user_session_detect_account(id){
				var _this = this;
				var user_id = {"user_id":id}
				var url = "~/api/"+_this.group_user_detect_account.source_table+"/get_obj?"
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
												_this.form["detect_account"] = id
									_this.disabledObj['detect_account' + '_isDisabled'] = true
						for (var i=0;i<arr.length;i++){
						  if (arr[i]!=='examine_state' && arr[i]!=='examine_reply') {
							for (var j = 0; j < arrForm.length; j++) {
							  if (arr[i] === arrForm[j]) {
								if (arr[i] !== "detect_account") {
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
					get_user_detect_account(id){
				var obj = this.list_user_detect_account.getObj({"user_id":id});
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
			 * 上传年检报告
			 * @param {Object} param 文件参数
			 */
			upload_annual_inspection_report(param){
						this.uploadFile(param.file, "annual_inspection_report");
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
								        if (this.form["annual_inspection_date"] && this.form["annual_inspection_date"].indexOf("-")===-1){
          this.form["annual_inspection_date"] = this.$toTime(parseInt(this.form["annual_inspection_date"]),"yyyy-MM-dd")
        }
			        if (this.form["next_annual_inspection"] && this.form["next_annual_inspection"].indexOf("-")===-1){
          this.form["next_annual_inspection"] = this.$toTime(parseInt(this.form["next_annual_inspection"]),"yyyy-MM-dd")
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
																		if(this.form["annual_inspection_date"]=="0000-00-00"){
				  this.form["annual_inspection_date"] = null;
				}
				if(parseInt(this.form["annual_inspection_date"]) > 9999){
					this.form["annual_inspection_date"] = this.$toTime(parseInt(this.form["annual_inspection_date"]),"yyyy-MM-dd")
				}
									if(this.form["next_annual_inspection"]=="0000-00-00"){
				  this.form["next_annual_inspection"] = null;
				}
				if(parseInt(this.form["next_annual_inspection"]) > 9999){
					this.form["next_annual_inspection"] = this.$toTime(parseInt(this.form["next_annual_inspection"]),"yyyy-MM-dd")
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
					bl = this.$check_action('/annual_inspection_report/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/annual_inspection_report/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/annual_inspection_report/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/annual_inspection_report/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/annual_inspection_report/view','get');
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
					this.get_list_user_detect_account();
					this.get_group_user_detect_account();
										this.get_list_user_car_owner_account();
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
