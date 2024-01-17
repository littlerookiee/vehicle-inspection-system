<template>
	<div class="page_root" id="root_index">
		<div class="warp">
			<div class="container-fluid">
				<el-row>
					<el-col :span="4">
						<div_label bg_color="bg_purple" icon="el-icon-user-solid" :url="url_user_count" unit="人"
								  title="用户数量"></div_label>
					</el-col>
				</el-row>

				<el-row>
									<el-col v-if="user_group == '管理员' || $check_figure('/vehicle_information/table')" :span="8">
						<div class="card chart">
																																																			<pieChart v-if="list_vehicle_information.length" id="list_vehicle_information" :list="list_vehicle_information" :title="'车辆信息统计'"></pieChart>
							<div v-if="!list_vehicle_information.length">车辆信息没有符合条件的数据</div>
																																																									</div>
					</el-col>
									<el-col v-if="user_group == '管理员' || $check_figure('/annual_inspection_appointment/table')" :span="8">
						<div class="card chart">
									<newBarChart v-if="bar_obj_annual_inspection_appointment.values.length > 0" id="bar_obj_annual_inspection_appointment" :vm="bar_obj_annual_inspection_appointment" :title="'年检预约统计'">
							</newBarChart>
							<div v-if="!bar_obj_annual_inspection_appointment.values.length">年检预约没有符合条件的数据</div>
								</div>
					</el-col>
								<el-col v-if="user_group == '管理员' || $check_figure('/annual_inspection_report/table')" :span="8">
						<div class="card chart">
																																																																																																																																																					<pieChart v-if="list_annual_inspection_report.length" id="list_annual_inspection_report" :list="list_annual_inspection_report" :title="'年检报告统计'"></pieChart>
							<div v-if="!list_annual_inspection_report.length">年检报告没有符合条件的数据</div>
																													</div>
					</el-col>
						</el-row>


			</div>
		</div>
	</div>
</template>
<script>
	import mixin from "@/mixins/page.js";
	import pieChart from "@/components/charts/pie_chart";
	import newBarChart from "@/components/charts/new_bar_chart";
	import div_label from "@/components/div_label.vue";
	export default {
		mixins: [mixin],
		name: "Home",
		components: {
			pieChart,
			newBarChart,
			div_label
		},
		data() {
			return {
				activeName: "third",
											list_vehicle_information: [],
										bar_obj_annual_inspection_appointment: {
					names:[],
					xAxis: [],
					values:[]
				},
								list_annual_inspection_report: [],
							url_user_count: "~/api/user/count?",
			};
		},
		created() {
							// 执行车辆信息数据获取
			this.get_list_vehicle_information();
							// 执行年检预约数据获取
			this.get_list_annual_inspection_appointment();
						// 执行年检报告数据获取
			this.get_list_annual_inspection_report();
				},
		mounted() {},
		methods: {
			async get_nickname(list,flag){
				if (flag) {
					for (let i=0;i<list.length;i++){
						await this.$get(
								"~/api/user/get_obj?user_id="+list[i],
								null,
								(json) => {
									if (json.result) {
										list[i] = json.result.obj.nickname;
									}
								});
					}
				}else {
					for (let i=0;i<list.length;i++){
						await this.$get(
								"~/api/user/get_obj?user_id="+list[i].name,
								null,
								(json) => {
									if (json.result) {
										list[i].name = json.result.obj.nickname;
									}
								});
					}
				}
			},
																																								// 获取车辆信息统计图数据
			get_list_vehicle_information() {
				let data = {};
								let flag = false;
												let user_group = this.$store.state.user.user_group;
				let user_id = this.$store.state.user.user_id;
				if (user_group!='管理员'){
										let sqlwhere = "(";
																		if (user_group=="车主用户"){
						sqlwhere+= "car_owner_account = " + user_id + " or ";
					}
																																																																																																																																																																	if (sqlwhere.length>1){
						sqlwhere = sqlwhere.substr(0,sqlwhere.length-4);
						sqlwhere += ")";
						data.sqlwhere = sqlwhere;
					}
									}
								this.$get("~/api/vehicle_information/list_group?groupby=vehicle_model", data, (json) => {
					if (json.result) {
						var list = json.result.list;
						this.list_vehicle_information = list.map((o) => {
							return {
												name: o[1],
												value: o[0]
							};
						});
						if (flag){
							this.get_nickname(this.list_vehicle_information,false);
						}
					}
				});
			},
																																												// 获取年检预约统计图
			async get_list_annual_inspection_appointment() {
				let name_list = [];
				let query_str = "";
																																																																																												name_list.push("检测价格");
				query_str = query_str+"testing_prices"+","
												let group_by_value = "appointment_time";
								let flag = false;
												let date_flag = "日长"
																																this.bar_obj_annual_inspection_appointment.names = name_list
				query_str = query_str.substr(0,query_str.length-1);
				let data = {};
						let user_group = this.$store.state.user.user_group;
				let user_id = this.$store.state.user.user_id;
				if (user_group!='管理员'){
								let sqlwhere = "(";
														if (user_group=="车主用户"){
						sqlwhere+= "car_owner_account = " + user_id + " or ";
					}
																																																																																																																																			if (sqlwhere.length>1){
						sqlwhere = sqlwhere.substr(0,sqlwhere.length-4);
						sqlwhere += ")";
						data.sqlwhere = sqlwhere;
					}
							}
						await this.$get(
						"~/api/annual_inspection_appointment/bar_group?field="+query_str+"&groupby="+group_by_value,
						data,
						(json) => {
							if (json.result) {
								let xAxis = [];
								let values = [];
								json.result.list.map((o) => {
									if (date_flag === "日期") {
										xAxis.push(this.$toTime(o[0] ,"yyyy-MM-dd"));
									}else if (date_flag === "时间") {
										xAxis.push(this.$toTime(o[0] ,"hh:mm:ss"));
									}else if (date_flag === "日长") {
										xAxis.push(this.$toTime(o[0] ,"yyyy-MM-dd hh:mm:ss"));
									}else {
										xAxis.push(o[0]);
									}
									values.push(o.splice(1))
								});
								this.bar_obj_annual_inspection_appointment.xAxis = xAxis;
								this.bar_obj_annual_inspection_appointment.values = values;
							}
							if (flag){
								this.get_nickname(this.bar_obj_annual_inspection_appointment.xAxis,true);
							}
						});
			},
																																																																																																											// 获取年检报告统计图数据
			get_list_annual_inspection_report() {
				let data = {};
								let flag = false;
												let user_group = this.$store.state.user.user_group;
				let user_id = this.$store.state.user.user_id;
				if (user_group!='管理员'){
										let sqlwhere = "(";
																		if (user_group=="检测用户"){
						sqlwhere+= "detect_account = " + user_id + " or ";
					}
																																						if (user_group=="车主用户"){
						sqlwhere+= "car_owner_account = " + user_id + " or ";
					}
																																																																																																																																																																																																																																																																									if (sqlwhere.length>1){
						sqlwhere = sqlwhere.substr(0,sqlwhere.length-4);
						sqlwhere += ")";
						data.sqlwhere = sqlwhere;
					}
									}
								this.$get("~/api/annual_inspection_report/list_group?groupby=annual_inspection_status", data, (json) => {
					if (json.result) {
						var list = json.result.list;
						this.list_annual_inspection_report = list.map((o) => {
							return {
												name: o[1],
												value: o[0]
							};
						});
						if (flag){
							this.get_nickname(this.list_annual_inspection_report,false);
						}
					}
				});
			},
																		
		},
		computed:{
			recognitionHeight(){
				return "830px"
			},
			recognitionUrl(){
				return "https://www.faceplusplus.com.cn/${model.filter.recognitionType}/"
			}
		}
	};
</script>

<style scoped="scoped">
	.chart {
		display: block;
		width: 100%;
		height: 400px;
		padding: 1rem;
		position: relative;
	}

	.el-col {
		padding: 0.5rem;
	}

	.card {
		overflow: hidden;
	}

	.iframe_box ,.iframe_box_change{
		width: 100%;
		height: 1180px;
		position: relative;
		margin-top: 25px;
	}
	.iframe_box_change{
		height: 580px;
		padding-top: 50px;
	}
	.iframe_box	.iframe_box_content, .iframe_box_change .iframe_box_content{
		width: 100%;
		height: 100%;
	}
	.iframe_box_top{
		position: absolute;
		top: 0;
		left: 0;
		width: 100%;
		height: 100px;
		font-size: 25px;
		line-height: 100px;
		background: #fff;
		z-index: 99999999;
		padding-left: 50px;
	}
	#iframe_box_face div::before {
		content: '';
		width: 100px;
		position: absolute;
		top: 154px;
		right: 129px;
		z-index: 999;
		height: 20px;
		background-color: #FFFFFF;
	}

	#iframe_box_face>h1 {
		margin-top: 100px;
		margin-bottom: 20px;
	}
</style>
