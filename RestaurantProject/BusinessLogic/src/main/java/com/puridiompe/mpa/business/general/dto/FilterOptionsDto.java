package com.puridiompe.mpa.business.general.dto;

import java.util.ArrayList;
import java.util.List;

public class FilterOptionsDto {
	
	 private String model;
     private String type;
     private String typeOption;
     private String label;
     private String operator;
     private String option;
     private String value;
     private Integer count;
     private Integer order;
     private Boolean enabled;
     private List<FilterOptionsDto> optionList;
     
     public FilterOptionsDto(){
    	 optionList = new ArrayList<FilterOptionsDto>();
     }

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTypeOption() {
		return typeOption;
	}

	public void setTypeOption(String typeOption) {
		this.typeOption = typeOption;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<FilterOptionsDto> getOptionList() {
		return optionList;
	}

	public void setOptionList(List<FilterOptionsDto> optionList) {
		this.optionList = optionList;
	}    

}
