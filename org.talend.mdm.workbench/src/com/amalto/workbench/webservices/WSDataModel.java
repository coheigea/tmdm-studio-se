// This class was generated by the JAXRPC SI, do not edit.
// Contents subject to change without notice.
// JAX-RPC Standard Implementation ��1.1.2_01������� R40��
// Generated source version: 1.1.2

package com.amalto.workbench.webservices;


public class WSDataModel {
    protected java.lang.String name;
    protected java.lang.String description;
    protected java.lang.String xsdSchema;
    
    public WSDataModel() {
    }
    
    public WSDataModel(java.lang.String name, java.lang.String description, java.lang.String xsdSchema) {
        this.name = name;
        this.description = description;
        this.xsdSchema = xsdSchema;
    }
    
    public java.lang.String getName() {
        return name;
    }
    
    public void setName(java.lang.String name) {
        this.name = name;
    }
    
    public java.lang.String getDescription() {
        return description;
    }
    
    public void setDescription(java.lang.String description) {
        this.description = description;
    }
    
    public java.lang.String getXsdSchema() {
        return xsdSchema;
    }
    
    public void setXsdSchema(java.lang.String xsdSchema) {
        this.xsdSchema = xsdSchema;
    }
}