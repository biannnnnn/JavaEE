package com.bdx.backend.entity;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @PROJECT_NAME: Backend
 * @DESCRIPTION:
 * @USER: bian
 * @DATE: 2022/10/26 11:58
 */
@TableName("contract")
public class Contract {
    private int contractId;
    private String barcode;
    private String type;
    private int retailerId;
    private String createTime;

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRetailerId() {
        return retailerId;
    }

    public void setRetailerId(int retailerId) {
        this.retailerId = retailerId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "contractId=" + contractId +
                ", barcode=" + barcode +
                ", type='" + type + '\'' +
                ", retailerId=" + retailerId +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
