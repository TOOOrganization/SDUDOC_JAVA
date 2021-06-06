(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d229824"],{de6c:function(e,t,r){"use strict";r.r(t);var a=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("v-container",[r("v-row",[r("v-col",{attrs:{cols:2}},[r("v-form",{model:{value:e.valid,callback:function(t){e.valid=t},expression:"valid"}},[r("v-text-field",{attrs:{label:"查询字段"},model:{value:e.defaultField,callback:function(t){e.defaultField=t},expression:"defaultField"}}),r("v-text-field",{attrs:{label:"查询内容"},model:{value:e.query,callback:function(t){e.query=t},expression:"query"}}),r("v-text-field",{attrs:{label:"排序"},model:{value:e.sort,callback:function(t){e.sort=t},expression:"sort"}}),r("v-row",[r("v-col",[r("v-text-field",{attrs:{label:"start"},model:{value:e.start,callback:function(t){e.start=t},expression:"start"}})],1),r("v-col",[r("v-text-field",{attrs:{label:"rows"},model:{value:e.rows,callback:function(t){e.rows=t},expression:"rows"}})],1)],1),r("v-col",[r("v-btn",{staticClass:"mr-4",attrs:{color:"primary"},on:{click:function(t){return e.submit(e.start)}}},[e._v(" Execute Query ")])],1),r("v-col",[r("v-btn",{staticClass:"mr-4",attrs:{color:"primary"},on:{click:function(t){return e.check()}}},[e._v(" check ")])],1)],1)],1),r("v-col",{attrs:{cols:10}},[r("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}],ref:"multipleTable",attrs:{data:e.characters.slice((e.currentPage-1)*e.pageSize,e.currentPage*e.pageSize)},on:{"selection-change":e.handleSelectionChange}},[r("el-table-column",{attrs:{type:"selection",width:"55"}}),e._l(e.headers,(function(e){return r("el-table-column",{key:e.label,attrs:{prop:e.prop,label:e.label,"show-overflow-tooltip":!0}})}))],2),0!==e.characters.length?r("v-row",{staticStyle:{"margin-top":"20px"},attrs:{justify:"center"}},[r("v-col",[r("el-button",{attrs:{type:"danger"},on:{click:function(t){return e.deleteSelected()}}},[e._v("删除选中")]),e.diff?r("el-button",{attrs:{type:"danger"},on:{click:function(t){return e.deleteAll()}}},[e._v("全部删除")]):e._e()],1),r("v-col",[r("el-pagination",{attrs:{align:"center","current-page":e.currentPage,"page-size":10,layout:"total, prev, pager, next, jumper",total:e.returnNumber},on:{"current-change":e.handleCurrentChange}})],1)],1):e._e()],1)],1)],1)},n=[],c=r("1da1"),l=(r("4de4"),r("99af"),r("caad"),r("2532"),r("a434"),r("96cf"),{name:"SolrCharacter",data:function(){return{valid:!1,loading:!1,defaultField:"",query:"",sort:"",start:0,rows:10,headers:[{prop:"_id",label:"_id"},{prop:"character",label:"character"},{prop:"article",label:"article"},{prop:"page",label:"page"},{prop:"position",label:"position"}],characters:[],returnNumber:0,numFound:0,currentPage:1,pageSize:10,selectedCharacter:[],diff_character:[],diff:!1}},methods:{submit:function(){var e=this;return Object(c["a"])(regeneratorRuntime.mark((function t(){return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:e.loading=!0,e.diff=!1,e.getSolrData("dms_character",e.defaultField,e.query,e.sort,e.start,e.rows).then((function(t){console.log(t),e.numFound=t.numFound,e.characters=t.results,e.returnNumber=t.results.length})),e.loading=!1;case 4:case"end":return t.stop()}}),t)})))()},handleCurrentChange:function(e){console.log("当前页: ".concat(e)),this.currentPage=e},check:function(){var e=this;return Object(c["a"])(regeneratorRuntime.mark((function t(){var r,a,n,c,l;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return e.diff=!0,r=[],a=[],t.next=5,e.getSolrGroupData("dms_character","","","","","","article","article").then((function(e){r=e}));case 5:return t.next=7,e.getSolrData("dms_article","","","","","","_id").then((function(e){for(var t=0;t<e.results.length;t++)a.push(e.results[t]._id)}));case 7:if(console.log("character",r),console.log("article",a),n=r.concat(a).filter((function(e){return r.includes(e)&&!a.includes(e)})),console.log("difference",n),e.diff_character=n,c="",0!==n.length)for(l=0;l<n.length;l++)c+=n[l]+" ";else c="default";return t.next=16,e.getSolrData("dms_character","article",c,"","","","").then((function(t){console.log(t),e.numFound=t.numFound,e.characters=t.results,e.returnNumber=t.results.length}));case 16:case"end":return t.stop()}}),t)})))()},handleSelectionChange:function(e){this.selectedCharacter=e,console.log(this.selectedCharacter)},deleteOneMethod:function(e,t){for(var r=0;r<t.length;r++)e.splice(e.indexOf(t[r]),1);this.articles=e},deleteSelected:function(){for(var e=this,t=[],r=0;r<this.selectedCharacter.length;r++)t.push(this.selectedCharacter[r]._id);this.$confirm("此操作将永久删除这"+t.length+"个字, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(){e.deleteMany("dms_character",t).then((function(t){console.log(t),"success"===t&&e.deleteOneMethod(e.characters,e.selectedCharacter)}))})).catch((function(t){console.log(t),e.$message({type:"info",message:"已取消删除"})}))},deleteAll:function(){var e=this;return Object(c["a"])(regeneratorRuntime.mark((function t(){var r,a;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:for(r=[],a=0;a<e.characters.length;a++)r.push(e.characters[a]._id);e.$confirm("此操作将永久删除这"+r.length+"个字, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(){e.deleteMany("dms_character",r).then((function(t){console.log(t),"success"===t&&(e.characters=[])}))})).catch((function(t){console.log(t),e.$message({type:"info",message:"已取消删除"})}));case 3:case"end":return t.stop()}}),t)})))()}}}),o=l,s=r("2877"),i=r("6544"),u=r.n(i),d=r("8336"),h=r("62ad"),f=r("a523"),g=r("4bd4"),p=r("0fd9"),m=r("8654"),v=Object(s["a"])(o,a,n,!1,null,"710f7be8",null);t["default"]=v.exports;u()(v,{VBtn:d["a"],VCol:h["a"],VContainer:f["a"],VForm:g["a"],VRow:p["a"],VTextField:m["a"]})}}]);
//# sourceMappingURL=chunk-2d229824.aa9873e6.js.map