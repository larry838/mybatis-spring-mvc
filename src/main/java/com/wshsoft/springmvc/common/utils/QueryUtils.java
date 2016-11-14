package com.wshsoft.springmvc.common.utils;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;

import com.wshsoft.mybatis.mapper.EntityWrapper;

public class QueryUtils {
	/**
	 * 获取快速查询的条件SQL
	 * @param params 快速查询参数
	 * @param arguments 参数值列表
	 * @return 条件SQL
	 * @throws Exception
	 */
	public static <T> String getFastQuerySql(EntityWrapper<T> ew,Map<String, Object> params, List<Object> arguments) throws Exception {

//		如果传递的条件参数为空则返回空字符串
		if(params==null){
			return "";
		}
//		定义条件SQL
		StringBuffer conditionSql = new StringBuffer();
//		遍历参数，拼接SQL
		for(String key : params.keySet()){
			if("".equals(MapUtils.getString(params, key, "").trim()))
				continue;
			if(key.indexOf("_")!=-1){
				String field = key.substring(key.indexOf("_")+1, key.length());
//				equal
				if(key.startsWith("eq_")){
					conditionSql.append(" and ").append(field).append(" = ? ");
					arguments.add(MapUtils.getString(params, key));
					continue;
				}
//				not equal
				if(key.startsWith("ne_")){
					conditionSql.append(" and ").append(field).append(" != ? ");
					arguments.add(MapUtils.getString(params, key));
					continue;
				}
//				like
				if(key.startsWith("lk_")){
					conditionSql.append(" and ").append(field).append(" like ? ");
					arguments.add("%"+MapUtils.getString(params, key)+"%");
					continue;
				}
//				right like
				if(key.startsWith("rl_")){
					conditionSql.append(" and ").append(field).append(" like ? ");
					arguments.add("%"+MapUtils.getString(params, key));
					continue;
				}
//				left like
				if(key.startsWith("ll_")){
					conditionSql.append(" and ").append(field).append(" like ? ");
					arguments.add(MapUtils.getString(params, key)+"%");
					continue;
				}
//				is null
				if(key.startsWith("in_")){
					conditionSql.append(" and ").append(field).append(" is null ");
					continue;
				}
//				is not null
				if(key.startsWith("inn_")){
					conditionSql.append(" and ").append(field).append(" is not null ");
					continue;
				}
//				great then
				if(key.startsWith("gt_")){
					conditionSql.append(" and ").append(field).append(" > ? ");
					arguments.add(MapUtils.getString(params, key));
					continue;
				}
//				great then and equal
				if(key.startsWith("ge_")){
					conditionSql.append(" and ").append(field).append(" >= ? ");
					arguments.add(MapUtils.getString(params, key));
					continue;
				}
//				less then
				if(key.startsWith("lt_")){
					conditionSql.append(" and ").append(field).append(" < ? ");
					arguments.add(MapUtils.getString(params, key));
					continue;
				}
//				less then and equal
				if(key.startsWith("le_")){
					conditionSql.append(" and ").append(field).append(" <= ? ");
					arguments.add(MapUtils.getString(params, key));
					continue;
				}
			}
		}
//		返回条件SQL
		return conditionSql.toString();
	
	}
}
