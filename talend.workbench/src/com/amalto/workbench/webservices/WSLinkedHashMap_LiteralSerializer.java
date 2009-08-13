// This class was generated by the JAXRPC SI, do not edit.
// Contents subject to change without notice.
// JAX-RPC Standard Implementation ��1.1.2_01������� R40��
// Generated source version: 1.1.2

package com.amalto.workbench.webservices;

import com.sun.xml.rpc.encoding.*;
import com.sun.xml.rpc.encoding.xsd.XSDConstants;
import com.sun.xml.rpc.encoding.literal.*;
import com.sun.xml.rpc.encoding.literal.DetailFragmentDeserializer;
import com.sun.xml.rpc.encoding.simpletype.*;
import com.sun.xml.rpc.encoding.soap.SOAPConstants;
import com.sun.xml.rpc.encoding.soap.SOAP12Constants;
import com.sun.xml.rpc.streaming.*;
import com.sun.xml.rpc.wsdl.document.schema.SchemaConstants;
import javax.xml.namespace.QName;
import java.util.List;
import java.util.ArrayList;

public class WSLinkedHashMap_LiteralSerializer extends LiteralObjectSerializerBase implements Initializable  {
    private static final QName ns1_typedContentEntry_QNAME = new QName("", "typedContentEntry");
    private static final QName ns2_WSGetItemsPivotIndex$2d$pivotWithKeys$2d$typedContentEntry_TYPE_QNAME = new QName("urn-com-amalto-xtentis-webservice", "WSGetItemsPivotIndex-pivotWithKeys-typedContentEntry");
    private CombinedSerializer ns2_myWSGetItemsPivotIndexPivotWithKeysTypedContentEntry_LiteralSerializer;
    
    public WSLinkedHashMap_LiteralSerializer(QName type, String encodingStyle) {
        this(type, encodingStyle, false);
    }
    
    public WSLinkedHashMap_LiteralSerializer(QName type, String encodingStyle, boolean encodeType) {
        super(type, true, encodingStyle, encodeType);
    }
    
    public void initialize(InternalTypeMappingRegistry registry) throws Exception {
        ns2_myWSGetItemsPivotIndexPivotWithKeysTypedContentEntry_LiteralSerializer = (CombinedSerializer)registry.getSerializer("", com.amalto.workbench.webservices.WSGetItemsPivotIndexPivotWithKeysTypedContentEntry.class, ns2_WSGetItemsPivotIndex$2d$pivotWithKeys$2d$typedContentEntry_TYPE_QNAME);
    }
    
    public Object doDeserialize(XMLReader reader,
        SOAPDeserializationContext context) throws Exception {
        com.amalto.workbench.webservices.WSLinkedHashMap instance = new com.amalto.workbench.webservices.WSLinkedHashMap();
        Object member=null;
        QName elementName;
        List values;
        Object value;
        
        reader.nextElementContent();
        elementName = reader.getName();
        if ((reader.getState() == XMLReader.START) && (elementName.equals(ns1_typedContentEntry_QNAME))) {
            values = new ArrayList();
            for(;;) {
                elementName = reader.getName();
                if ((reader.getState() == XMLReader.START) && (elementName.equals(ns1_typedContentEntry_QNAME))) {
                    value = ns2_myWSGetItemsPivotIndexPivotWithKeysTypedContentEntry_LiteralSerializer.deserialize(ns1_typedContentEntry_QNAME, reader, context);
                    values.add(value);
                    reader.nextElementContent();
                } else {
                    break;
                }
            }
            member = new com.amalto.workbench.webservices.WSGetItemsPivotIndexPivotWithKeysTypedContentEntry[values.size()];
            member = values.toArray((Object[]) member);
            instance.setTypedContentEntry((com.amalto.workbench.webservices.WSGetItemsPivotIndexPivotWithKeysTypedContentEntry[])member);
        }
        else if(!(reader.getState() == XMLReader.END)) {
            throw new DeserializationException("literal.expectedElementName", reader.getName().toString());
        }
        
        XMLReaderUtil.verifyReaderState(reader, XMLReader.END);
        return (Object)instance;
    }
    
    public void doSerializeAttributes(Object obj, XMLWriter writer, SOAPSerializationContext context) throws Exception {
        com.amalto.workbench.webservices.WSLinkedHashMap instance = (com.amalto.workbench.webservices.WSLinkedHashMap)obj;
        
    }
    public void doSerialize(Object obj, XMLWriter writer, SOAPSerializationContext context) throws Exception {
        com.amalto.workbench.webservices.WSLinkedHashMap instance = (com.amalto.workbench.webservices.WSLinkedHashMap)obj;
        
        if (instance.getTypedContentEntry() != null) {
            for (int i = 0; i < instance.getTypedContentEntry().length; ++i) {
                ns2_myWSGetItemsPivotIndexPivotWithKeysTypedContentEntry_LiteralSerializer.serialize(instance.getTypedContentEntry()[i], ns1_typedContentEntry_QNAME, null, writer, context);
            }
        }
    }
}
