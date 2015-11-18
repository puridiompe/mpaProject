package com.puridiompe.mpa.business.general.dto;

import java.util.ArrayList;
import java.util.List;

public class FilterDto {
	
	private String model;
    private String type;
    private String typeOption;
    private String format;
    private String label;
    private Integer order;
    private Boolean enabled;
    private String value;
    private Boolean selected;
    private List<FilterOptionsDto> optionList;
    
    public FilterDto(){
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

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
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

	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
