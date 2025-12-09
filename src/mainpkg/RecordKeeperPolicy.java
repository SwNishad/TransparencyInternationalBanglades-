/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

import java.io.Serializable;


public class RecordKeeperPolicy implements Serializable {
    protected String policytype;
    protected String policycontent;

    @Override
    public String toString() {
        return policycontent;
    }

    public String getPolicytype() {
        return policytype;
    }

    public void setPolicytype(String policytype) {
        this.policytype = policytype;
    }

    public String getPolicycontent() {
        return policycontent;
    }

    public void setPolicycontent(String policycontent) {
        this.policycontent = policycontent;
    }

    public RecordKeeperPolicy(String policytype, String policycontent) {
        this.policytype = policytype;
        this.policycontent = policycontent;
    }
    
    
}

