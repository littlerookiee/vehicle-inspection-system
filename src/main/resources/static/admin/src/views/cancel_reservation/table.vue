<template>
	<el-main class="bg table_wrap comtabel_t">
		<el-form label-position="right" :model="query" class="form p_4" label-width="120">
			<el-row class="rows row1">



																												<el-col :xs="24" :sm="24" :lg="8" class="el_form_search_wrap">
					<el-form-item label="店铺名称">
									<el-input v-model="query.store_name"></el-input>
								</el-form-item>
				</el-col>
																								<el-col :xs="24" :sm="24" :lg="8" class="el_form_search_wrap">
					<el-form-item label="订单编号">
									<el-input v-model="query.order_number"></el-input>
								</el-form-item>
				</el-col>
													<el-col :xs="24" :sm="24" :lg="8" class="el_form_search_wrap">
					<el-form-item label="审核状态">
						<el-select v-model="query.examine_state">
							<el-option value="">全部</el-option>
							<el-option value="未审核">未审核</el-option>
							<el-option value="已通过">已通过</el-option>
							<el-option value="未通过">未通过</el-option>
						</el-select>
					</el-form-item>
				</el-col>
	</el-row>
	<el-row class="rows row2">

		<el-col :xs="24" :sm="24" :lg="24" class="search_btn_wrap search_btns">

				<el-col :xs="24" :sm="10" :lg="8" class="search_btn_1 search_btn_wrap_1 btns">

										<el-button type="primary" @click="search()" class="search_btn_find">查询</el-button>
						<el-button @click="reset()" style="margin-right: 74px;" class="search_btn_reset">重置</el-button>
																		

						<el-button v-if="user_group == '管理员' || $check_action('/cancel_reservation/table','del') || $check_action('/cancel_reservation/view','del')" class="search_btn_del" type="danger" @click="delInfo()">删除</el-button>
								
				</el-col>
		</el-col>
	</el-row >

		</el-form>
		<el-table :data="list" @selection-change="selectionChange" @sort-change="$sortChange" style="width: 100%" id="dataTable">
			<el-table-column fixed type="selection" tooltip-effect="dark" width="55">
			</el-table-column>
				<el-table-column prop="car_owner_account" @sort-change="$sortChange" label="车主账号"
				v-if="user_group == '管理员' || $check_field('get','car_owner_account')" min-width="200">
						<template slot-scope="scope">
					{{ get_user_car_owner_account(scope.row['car_owner_account']) }}
				</template>
					</el-table-column>
					<el-table-column prop="owners_name" @sort-change="$sortChange" label="车主姓名"
				v-if="user_group == '管理员' || $check_field('get','owners_name')" min-width="200">
					</el-table-column>
					<el-table-column prop="vehicle_owner_gender" @sort-change="$sortChange" label="车主性别"
				v-if="user_group == '管理员' || $check_field('get','vehicle_owner_gender')" min-width="200">
					</el-table-column>
					<el-table-column prop="car_owners_phone_number" @sort-change="$sortChange" label="车主电话"
				v-if="user_group == '管理员' || $check_field('get','car_owners_phone_number')" min-width="200">
					</el-table-column>
					<el-table-column prop="id_number" @sort-change="$sortChange" label="身份证号"
				v-if="user_group == '管理员' || $check_field('get','id_number')" min-width="200">
					</el-table-column>
					<el-table-column prop="vehicle_model" @sort-change="$sortChange" label="车辆车型"
				v-if="user_group == '管理员' || $check_field('get','vehicle_model')" min-width="200">
					</el-table-column>
					<el-table-column prop="license_plate_number" @sort-change="$sortChange" label="车牌号码"
				v-if="user_group == '管理员' || $check_field('get','license_plate_number')" min-width="200">
					</el-table-column>
					<el-table-column prop="store_name" @sort-change="$sortChange" label="店铺名称"
				v-if="user_group == '管理员' || $check_field('get','store_name')" min-width="200">
					</el-table-column>
					<el-table-column prop="detection_address" @sort-change="$sortChange" label="检测地址"
				v-if="user_group == '管理员' || $check_field('get','detection_address')" min-width="200">
					</el-table-column>
					<el-table-column prop="available_time_for_scheduling" @sort-change="$sortChange" label="可约时间"
				v-if="user_group == '管理员' || $check_field('get','available_time_for_scheduling')" min-width="200">
						<template slot-scope="scope">
					{{ $toTime(scope.row["available_time_for_scheduling"],"yyyy-MM-dd hh:mm:ss") }}
				</template>
					</el-table-column>
					<el-table-column prop="testing_prices" @sort-change="$sortChange" label="检测价格"
				v-if="user_group == '管理员' || $check_field('get','testing_prices')" min-width="200">
					</el-table-column>
					<el-table-column prop="appointment_time" @sort-change="$sortChange" label="预约时间"
				v-if="user_group == '管理员' || $check_field('get','appointment_time')" min-width="200">
						<template slot-scope="scope">
					{{ $toTime(scope.row["appointment_time"],"yyyy-MM-dd hh:mm:ss") }}
				</template>
					</el-table-column>
					<el-table-column prop="detection_content" @sort-change="$sortChange" label="检测内容"
				v-if="user_group == '管理员' || $check_field('get','detection_content')" min-width="200">
					</el-table-column>
					<el-table-column prop="order_number" @sort-change="$sortChange" label="订单编号"
				v-if="user_group == '管理员' || $check_field('get','order_number')" min-width="200">
					</el-table-column>
					<el-table-column prop="cancel_time" @sort-change="$sortChange" label="取消时间"
				v-if="user_group == '管理员' || $check_field('get','cancel_time')" min-width="200">
						<template slot-scope="scope">
					{{ $toTime(scope.row["cancel_time"],"yyyy-MM-dd hh:mm:ss") }}
				</template>
					</el-table-column>
					<el-table-column prop="reason_for_cancellation" @sort-change="$sortChange" label="取消原因"
				v-if="user_group == '管理员' || $check_field('get','reason_for_cancellation')" min-width="200">
					</el-table-column>
	
			<el-table-column label="审核状态" prop="examine_state">
			</el-table-column>

			<el-table-column label="审核回复" prop="examine_reply">
			</el-table-column>


            <el-table-column sortable prop="create_time" label="创建时间" min-width="200">
                <template slot-scope="scope">
                	{{ $toTime(scope.row["create_time"],"yyyy-MM-dd hh:mm:ss") }}
                </template>
            </el-table-column>

			<el-table-column sortable prop="update_time" label="更新时间" min-width="200">
                <template slot-scope="scope">
                	{{ $toTime(scope.row["update_time"],"yyyy-MM-dd hh:mm:ss") }}
                </template>
			</el-table-column>







			<el-table-column fixed="right" label="操作" min-width="200" v-if="user_group == '管理员' || $check_action('/cancel_reservation/table','set') || $check_action('/cancel_reservation/view','set') || $check_action('/cancel_reservation/view','get') || $check_action('//table','add') || $check_action('//view','add')" >


				<template slot-scope="scope">
					<div class="view_a">
					<router-link class="e-button el-button--small is-plain el-button--success" style="margin: 5px !important;"
					v-if="user_group == '管理员' || $check_action('/cancel_reservation/table','set') || $check_action('/cancel_reservation/view','set') || $check_action('/cancel_reservation/view','get')"
						:to="'./view?' + field + '=' + scope.row[field]"
						 size="small">
						<span>详情</span>
					</router-link>
				</div>
				</template>
			</el-table-column>

		</el-table>

		<!-- 分页器 -->
		<div class="mt text_center">
			<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange"
				:current-page="query.page" :page-sizes="[7, 10, 30, 100]" :page-size="query.size"
				layout="total, sizes, prev, pager, next, jumper" :total="count">
			</el-pagination>
		</div>
		<!-- /分页器 -->

																
		<div class="modal_wrap" v-if="showModal">
			<div class="modal_box">
				<!-- <div class="modal_box_close" @click="closeModal">X</div> -->
				<p class="modal_box_title">重要提醒</p>
				<p class="modal_box_text">当前有数据达到预警值！</p>
				<div class="btn_box">
					<span @click="closeModal">取消</span>
					<span @click="closeModal">确定</span>
				</div>
			</div>
		</div>


	</el-main>
</template>
<script>
	import mixin from "@/mixins/page.js";

	export default {
		mixins: [mixin],
		data() {
			return {
				// 弹框
				showModal: false,
				// 获取数据地址
				url_get_list: "~/api/cancel_reservation/get_list?like=0",
				url_del: "~/api/cancel_reservation/del?",

				// 字段ID
				field: "cancel_reservation_id",

				// 查询
				query: {
					"size": 7,
					"page": 1,
															"store_name": "",
																"order_number": "",
										"examine_state":"",
					"login_time": "",
					"create_time": "",
					"orderby": `create_time desc`
				},

				// 数据
				list: [],
																								// 用户列表
				list_user_car_owner_account: [],
																																		}
		},
		methods: {
			// 关闭弹框
			closeModal(){
				this.showModal = false;
				},

			get_list_before(param){
				var user_group = this.user.user_group;
				if(user_group != "管理员"){
						let sqlwhere = "(";
										if(user_group=="车主用户"){
						sqlwhere+= "car_owner_account = " + this.user.user_id + " or ";
					}
																																																																																					if (sqlwhere.length>1){
						sqlwhere = sqlwhere.substr(0,sqlwhere.length-4);
						sqlwhere += ")";
						param["sqlwhere"] = sqlwhere;
					}
					}
				return param;
			},

																																



				/**
			 * 获取车主用户用户列表
			 */
			async get_list_user_car_owner_account() {
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
					ret = obj.nickname+"-"+obj.username;
					// if(obj.nickname){
					// 	ret = obj.nickname;
					// }
					// else{
					// 	ret = obj.username;
					// }
				}
				return ret;
			},
																																		},
		created() {
							this.get_list_user_car_owner_account();
																																	}
	}
</script>

<style type="text/css">
	.bg {
		background: white;
	}

	.form.p_4 {
		padding: 1rem;
	}

	.form .el-input {
		width: initial;
	}

	.mt {
		margin-top: 1rem;
	}

	.text_center {
		text-align: center;
	}

	.float-right {
		float: right;
	}


	.modal_wrap{
		width: 100vw;
		height: 100vh;
		position: fixed;
		top: 0;
		left: 0;
		background: rgba(0,0,0,0.5);
		z-index: 9999999999;
	}
	.modal_wrap .modal_box{
		width: 400px;
		height: 200px;
		background: url("../../assets/modal_bg.jpg") no-repeat center;
		background-size: cover;
		position: absolute;
		top: 50%;
		left: 50%;
		margin-left: -200px;
		margin-top: -100px;
		border-radius: 10px;
		}
	.modal_wrap .modal_box .modal_box_close{
		font-size: 20px;
		position: absolute;
		top: 10px;
		right: 10px;
		cursor: pointer;
		}
	.modal_wrap .modal_box .modal_box_title{
	  text-align: center;
    font-size: 18px;
    margin: 16px auto;
    color: #fff;
    border-bottom: 1px solid rgba(117, 116, 116,0.5);
    padding-bottom: 16px;
    width: 356px;
		}
	.modal_wrap .modal_box .modal_box_text{
			text-align: center;
		font-size: 15px;
		color: #fff;
		margin-top: 25px;
		}
	.modal_wrap .modal_box .btn_box{
		display: flex;
		flex-direction: row;
		justify-content: center;
		margin-top: 42px;
		}
			.modal_wrap .modal_box .btn_box span{
				display: inline-block;
				width: 80px;
				height: 30px;
				line-height: 30px;
				text-align: center;
				border: 1px solid #ccc;
				font-size: 14px;
				cursor: pointer;
				color: #fff;
			}
	.modal_wrap .modal_box .btn_box span:nth-child(2){
		background: #409EFF;
		color: #fff;
		border-color: #409EFF;
		margin-left: 15px;
	}
</style>
