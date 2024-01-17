<template>
	<el-main class="bg table_wrap comtabel_t">
		<el-form label-position="right" :model="query" class="form p_4" label-width="120">
			<el-row class="rows row1">



																																																				<el-col :xs="24" :sm="24" :lg="8" class="el_form_search_wrap">
					<el-form-item label="订单编号">
									<el-input v-model="query.order_number"></el-input>
								</el-form-item>
				</el-col>
												<el-col :xs="24" :sm="24" :lg="8" class="el_form_search_wrap">
					<el-form-item label="下次年检">
									<el-input v-model="query.next_annual_inspection"></el-input>
								</el-form-item>
				</el-col>
																</el-row>
	<el-row class="rows row2">

		<el-col :xs="24" :sm="24" :lg="24" class="search_btn_wrap search_btns">

				<el-col :xs="24" :sm="10" :lg="8" class="search_btn_1 search_btn_wrap_1 btns">

										<el-button type="primary" @click="search()" class="search_btn_find">查询</el-button>
						<el-button @click="reset()" style="margin-right: 74px;" class="search_btn_reset">重置</el-button>
														<el-button v-if="$check_option('/annual_inspection_report/table','export_db')" @click="export_db('dataTable')" class="derive" style="margin-right: 155px;">导出</el-button>
														

						<el-button v-if="user_group == '管理员' || $check_action('/annual_inspection_report/table','del') || $check_action('/annual_inspection_report/view','del')" class="search_btn_del" type="danger" @click="delInfo()">删除</el-button>
								
				</el-col>
		</el-col>
	</el-row >

		</el-form>
		<el-table :data="list" @selection-change="selectionChange" @sort-change="$sortChange" style="width: 100%" id="dataTable">
			<el-table-column type="selection" tooltip-effect="dark" width="55">
			</el-table-column>
				<el-table-column prop="detect_account" @sort-change="$sortChange" label="检测账号"
				v-if="user_group == '管理员' || $check_field('get','detect_account')" min-width="200">
						<template slot-scope="scope">
					{{ get_user_detect_account(scope.row['detect_account']) }}
				</template>
					</el-table-column>
					<el-table-column prop="user_name" @sort-change="$sortChange" label="用户姓名"
				v-if="user_group == '管理员' || $check_field('get','user_name')" min-width="200">
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
					<el-table-column prop="annual_inspection_date" @sort-change="$sortChange" label="年检日期"
				v-if="user_group == '管理员' || $check_field('get','annual_inspection_date')" min-width="200">
		                <template slot-scope="scope">
                	{{ $toTime(scope.row["annual_inspection_date"],"yyyy-MM-dd") }}
                </template>
					</el-table-column>
					<el-table-column prop="next_annual_inspection" @sort-change="$sortChange" label="下次年检"
				v-if="user_group == '管理员' || $check_field('get','next_annual_inspection')" min-width="200">
		                <template slot-scope="scope">
                	{{ $toTime(scope.row["next_annual_inspection"],"yyyy-MM-dd") }}
                </template>
					</el-table-column>
					<el-table-column prop="annual_inspection_report" @sort-change="$sortChange" label="年检报告"
				v-if="user_group == '管理员' || $check_field('get','annual_inspection_report')" min-width="200">
						<template slot-scope="scope">
					<a :href="$fullUrl(scope.row['annual_inspection_report'])" target="_blank" style="color: rgb(64, 158, 255);">点击下载</a>
				</template>
					</el-table-column>
					<el-table-column prop="annual_inspection_status" @sort-change="$sortChange" label="年检状态"
				v-if="user_group == '管理员' || $check_field('get','annual_inspection_status')" min-width="200">
					</el-table-column>
					<el-table-column prop="annual_inspection_results" @sort-change="$sortChange" label="年检结果"
				v-if="user_group == '管理员' || $check_field('get','annual_inspection_results')" min-width="200">
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







			<el-table-column label="操作" min-width="200" v-if="user_group == '管理员' || $check_action('/annual_inspection_report/table','set') || $check_action('/annual_inspection_report/view','set') || $check_action('/annual_inspection_report/view','get') || $check_action('//table','add') || $check_action('//view','add')" >


				<template slot-scope="scope">
					<div class="view_a">
					<router-link class="e-button el-button--small is-plain el-button--success" style="margin: 5px !important;"
					v-if="user_group == '管理员' || $check_action('/annual_inspection_report/table','set') || $check_action('/annual_inspection_report/view','set') || $check_action('/annual_inspection_report/view','get')"
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
				url_get_list: "~/api/annual_inspection_report/get_list?like=0",
				url_del: "~/api/annual_inspection_report/del?",

				// 字段ID
				field: "annual_inspection_report_id",

				// 查询
				query: {
					"size": 7,
					"page": 1,
																							"order_number": "",
												"next_annual_inspection": "",
												"login_time": "",
					"create_time": "",
					"orderby": `create_time desc`
				},

				// 数据
				list: [],
																														// 用户列表
				list_user_detect_account: [],
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
										if(user_group=="检测用户"){
						sqlwhere+= "detect_account = " + this.user.user_id + " or ";
					}
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
			 * 导出
			 */
			export_db(tableid){
				// var query = this.query;
				// this.$get("~/api/annual_inspection_report/export_db?",query,(json)=>{
				// 	if(json.result){
				// 		console.log(json.result);
				// 	}else if(json.error){
				// 		console.error(json.error);
				// 	}
				// });


				//导出表格
        var idTmr;

        function getExplorer() {
            var explorer = window.navigator.userAgent;
            //ie
            if(explorer.indexOf("MSIE") >= 0) {
                return 'ie';
            }
            //firefox
            else if(explorer.indexOf("Firefox") >= 0) {
                return 'Firefox';
            }
            //Chrome
            else if(explorer.indexOf("Chrome") >= 0) {
                return 'Chrome';
            }
            //Opera
            else if(explorer.indexOf("Opera") >= 0) {
                return 'Opera';
            }
            //Safari
            else if(explorer.indexOf("Safari") >= 0) {
                return 'Safari';
            }
        }
        function Cleanup() {
            window.clearInterval(idTmr);
            CollectGarbage();
        }
        var tableToExcel = (function() {
            var uri = 'data:application/vnd.ms-excel;base64,',
                template = '<html><head><meta charset="UTF-8"></head><body><table  border="1">{table}</table></body></html>',
                base64 = function(
                    s) {
                    return window.btoa(unescape(encodeURIComponent(s)))
                },
                format = function(s, c) {
                    return s.replace(/{(\w+)}/g, function(m, p) {
                        return c[p];
                    })
                }
            return function(table, name) {
                if(!table.nodeType)
                    table = document.getElementById(table)
                var ctx = {
                    worksheet: name || 'Worksheet',
                    table: table.innerHTML
                }
                window.location.href = uri + base64(format(template, ctx))
            }
        })();
            if(getExplorer() == 'ie') {
                var curTbl = document.getElementById(tableid);
                var oXL = new ActiveXObject("Excel.Application");
                var oWB = oXL.Workbooks.Add();
                var xlsheet = oWB.Worksheets(1);
                var sel = document.body.createTextRange();
                sel.moveToElementText(curTbl);
                sel.select();
                sel.execCommand("Copy");
                xlsheet.Paste();
                oXL.Visible = true;

                try {
                    var fname = oXL.Application.GetSaveAsFilename("Excel.xls",
                        "Excel Spreadsheets (*.xls), *.xls");
                } catch(e) {
                    print("Nested catch caught " + e);
                } finally {
                    oWB.SaveAs(fname);
                    oWB.Close(savechanges = false);
                    oXL.Quit();
                    oXL = null;
                    idTmr = window.setInterval("Cleanup();", 1);
                }

            } else {
                tableToExcel(tableid)
            }


			},



				/**
			 * 获取检测用户用户列表
			 */
			async get_list_user_detect_account() {
				var json = await this.$get("~/api/user/get_list?user_group=检测用户");
				if(json.result && json.result.list){
					this.list_user_detect_account = json.result.list;
				}
				else if(json.error){
					console.error(json.error);
				}
			},

			get_user_detect_account(id){
				var obj = this.list_user_detect_account.getObj({"user_id":id});
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
							this.get_list_user_detect_account();
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
