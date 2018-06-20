package com.suikajy.demo.json.bean;


import java.util.ArrayList;

/**
 * @author Qin
 * @data 2018/5/31
 * Content
 */

public class InvoiceIssUingApplicationBean {

    private boolean mYes;
    private boolean no;
    private String InvoiceType;
    private String itemid;
    private String mTvReceiptUp;
    private String mTvTime;
    private String mTvMoney;
    private String companyName;
    private String useTheNumber;
    private String unitAddress;
    private String unitNumber;
    private String depositBank;
    private String bankAccount;
    private String invoiceMoney;
    private String toTheAmount;
    private String toTime;
    private ArrayList<?> mCopyName = new ArrayList<>();
    private ArrayList<?> mCopyId = new ArrayList<>();
    private ArrayList<?> mSrcPath = new ArrayList<>();
    private String shenpiId;
    private boolean geRen;
    private boolean gongYou;
    private String mGeRen;
    private String mGongYou;

    public String getmGeRen() {
        return mGeRen;
    }

    public void setmGeRen(String mGeRen) {
        this.mGeRen = mGeRen;
    }

    public String getmGongYou() {
        return mGongYou;
    }

    public void setmGongYou(String mGongYou) {
        this.mGongYou = mGongYou;
    }

    public boolean isGeRen() {
        return geRen;
    }

    public void setGeRen(boolean geRen) {
        this.geRen = geRen;
    }

    public boolean isGongYou() {
        return gongYou;
    }

    public void setGongYou(boolean gongYou) {
        this.gongYou = gongYou;
    }

    private ArrayList<String> mFileData = new ArrayList<>();

    public String getInvoiceType() {
        return InvoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        InvoiceType = invoiceType;
    }

    public boolean ismYes() {
        return mYes;
    }

    public void setmYes(boolean mYes) {
        this.mYes = mYes;
    }

    public boolean isNo() {
        return no;
    }

    public void setNo(boolean no) {
        this.no = no;
    }

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    public String getmTvReceiptUp() {
        return mTvReceiptUp;
    }

    public void setmTvReceiptUp(String mTvReceiptUp) {
        this.mTvReceiptUp = mTvReceiptUp;
    }

    public String getmTvTime() {
        return mTvTime;
    }

    public void setmTvTime(String mTvTime) {
        this.mTvTime = mTvTime;
    }

    public String getmTvMoney() {
        return mTvMoney;
    }

    public void setmTvMoney(String mTvMoney) {
        this.mTvMoney = mTvMoney;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getUseTheNumber() {
        return useTheNumber;
    }

    public void setUseTheNumber(String useTheNumber) {
        this.useTheNumber = useTheNumber;
    }

    public String getUnitAddress() {
        return unitAddress;
    }

    public void setUnitAddress(String unitAddress) {
        this.unitAddress = unitAddress;
    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }

    public String getDepositBank() {
        return depositBank;
    }

    public void setDepositBank(String depositBank) {
        this.depositBank = depositBank;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getInvoiceMoney() {
        return invoiceMoney;
    }

    public void setInvoiceMoney(String invoiceMoney) {
        this.invoiceMoney = invoiceMoney;
    }

    public String getToTheAmount() {
        return toTheAmount;
    }

    public void setToTheAmount(String toTheAmount) {
        this.toTheAmount = toTheAmount;
    }

    public String getToTime() {
        return toTime;
    }

    public void setToTime(String toTime) {
        this.toTime = toTime;
    }

    public ArrayList<?> getmCopyName() {
        return mCopyName;
    }

    public void setmCopyName(ArrayList<?> mCopyName) {
        this.mCopyName = mCopyName;
    }

    public ArrayList<?> getmCopyId() {
        return mCopyId;
    }

    public void setmCopyId(ArrayList<?> mCopyId) {
        this.mCopyId = mCopyId;
    }

    public ArrayList<?> getmSrcPath() {
        return mSrcPath;
    }

    public void setmSrcPath(ArrayList<?> mSrcPath) {
        this.mSrcPath = mSrcPath;
    }

    public String getShenpiId() {
        return shenpiId;
    }

    public void setShenpiId(String shenpiId) {
        this.shenpiId = shenpiId;
    }

    public ArrayList<String> getmFileData() {
        return mFileData;
    }

    public void setmFileData(ArrayList<String> mFileData) {
        this.mFileData = mFileData;
    }

    @Override
    public String toString() {
        return "InvoiceIssUingApplicationBean{" +
                ", mYes=" + mYes +
                ", no=" + no +
                ", InvoiceType='" + InvoiceType + '\'' +
                ", itemid='" + itemid + '\'' +
                ", mTvReceiptUp='" + mTvReceiptUp + '\'' +
                ", mTvTime='" + mTvTime + '\'' +
                ", mTvMoney='" + mTvMoney + '\'' +
                ", companyName='" + companyName + '\'' +
                ", useTheNumber='" + useTheNumber + '\'' +
                ", unitAddress='" + unitAddress + '\'' +
                ", unitNumber='" + unitNumber + '\'' +
                ", depositBank='" + depositBank + '\'' +
                ", bankAccount='" + bankAccount + '\'' +
                ", invoiceMoney='" + invoiceMoney + '\'' +
                ", toTheAmount='" + toTheAmount + '\'' +
                ", toTime='" + toTime + '\'' +
                ", mCopyName=" + mCopyName +
                ", mCopyId=" + mCopyId +
                ", mSrcPath=" + mSrcPath +
                ", shenpiId='" + shenpiId + '\'' +
                ", mFileData=" + mFileData +
                '}';
    }
}
