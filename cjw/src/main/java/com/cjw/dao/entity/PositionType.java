package com.cjw.dao.entity;

import java.io.Serializable;

public class PositionType implements Serializable {
    private Integer positionTypeId;

    private String positionTypeName;

    private Integer parent;

    private Integer state;

    private static final long serialVersionUID = 1L;

    public Integer getPositionTypeId() {
        return positionTypeId;
    }

    public void setPositionTypeId(Integer positionTypeId) {
        this.positionTypeId = positionTypeId;
    }

    public String getPositionTypeName() {
        return positionTypeName;
    }

    public void setPositionTypeName(String positionTypeName) {
        this.positionTypeName = positionTypeName == null ? null : positionTypeName.trim();
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}