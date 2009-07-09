package com.amalto.core.plugin.base.batchproject.ejb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Pattern;

import javax.ejb.SessionBean;

import org.w3c.dom.Element;

import com.amalto.core.objects.transformers.v2.ejb.TransformerPluginV2CtrlBean;
import com.amalto.core.objects.transformers.v2.util.TransformerPluginContext;
import com.amalto.core.objects.transformers.v2.util.TransformerPluginVariableDescriptor;
import com.amalto.core.objects.transformers.v2.util.TypedContent;
import com.amalto.core.plugin.base.batchproject.CompiledParameters;
import com.amalto.core.util.Util;
import com.amalto.core.util.XtentisException;

/**
 *
 * @author Starkey Shu
 *
 * @ejb.bean name="BatchProjectPlugin"
 *           display-name="Name for BatchProjectPlugin"
 *           description="Description for BatchProjectPlugin"
 * 		     local-jndi-name = "amalto/local/transformer/plugin/batchproject"
 *           type="Stateless"
 *           view-type="local"
 *           local-business-interface="com.amalto.core.objects.transformers.v2.util.TransformerPluginV2LocalInterface"
 *
 * @ejb.remote-facade
 *
 * @ejb.permission
 * 	view-type = "remote"
 * 	role-name = "administration"
 * @ejb.permission
 * 	view-type = "local"
 * 	unchecked = "true"
 *
 *
 */
     

public class BatchProjectTransformerPluginBean extends TransformerPluginV2CtrlBean  implements SessionBean{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1100573389664234095L;
	//parameters
	public static final String PARAMETERS ="com.amalto.core.plugin.batchproject.parameters";
	//various
	private static final String INPUT_XML ="xml_instance";
	private static final String OUTPUT_TEXT ="success_number";

    private transient boolean configurationLoaded = false;

	public BatchProjectTransformerPluginBean() {
		super();
		try {
			getConfiguration(null);
		} catch (Exception e) {};
	}
	
	/**
     * @throws XtentisException
     *
     * @ejb.interface-method view-type = "local"
     * @ejb.facade-method
     */
	public String getJNDIName() throws XtentisException {
		return "amalto/local/transformer/plugin/batchproject";
	}
	
	/**
     * @throws XtentisException
     *
     * @ejb.interface-method view-type = "local"
     * @ejb.facade-method
     */
	public String getDescription(String twoLettersLanguageCode)
			throws XtentisException {
		String description="";
		if(twoLettersLanguageCode.toLowerCase().equals("en")){
			description="Batch projecting items to the Data Manager";
		}else{
			description="Unsupported language! ";
		}
		return description;
	}

	/**
     * @throws XtentisException
     *
     * @ejb.interface-method view-type = "local"
     * @ejb.facade-method
     */
	public String getDocumentation(String twoLettersLanguageCode)
			throws XtentisException {
		return
		"Batch projecting items with the same concept to a specific Data Cluster. \n" +
		"\n" +
		"\n" +
		"Parameters\n" +
		"	dataClusterName [mandatory]: the Data Cluster to use "+"\n"+
		"	dataModelName [mandatory]: the Data Model to use "+"\n"+
		"	conceptName [mandatory]: the Concept Model to use "+"\n"+
		"\n"+
		"\n"+
		"Example" +"\n"+
		"	<parameters>" +"\n"+
		"		<dataClusterName>Order</dataClusterName>" +"\n"+
		"		<dataModelName>Order</dataModelName>" +"\n"+
		"		<conceptName>Customer</conceptName>" +"\n"+
		"	</parameters>"+"\n"+
		"\n"+
		"\n"+
		"Notes for Plugin Developers: " +"\n"+
		"		empty"	;
	}
	
	/**
     * @throws XtentisException
     *
     * @ejb.interface-method view-type = "local"
     * @ejb.facade-method
     */
	public ArrayList<TransformerPluginVariableDescriptor> getInputVariableDescriptors(
			String twoLettersLanguageCode) throws XtentisException {
		 ArrayList<TransformerPluginVariableDescriptor> inputDescriptors = new ArrayList<TransformerPluginVariableDescriptor>();
		
		 TransformerPluginVariableDescriptor descriptor = new TransformerPluginVariableDescriptor();
		 descriptor.setVariableName(INPUT_XML);
		 descriptor.setContentTypesRegex(
				 new ArrayList<Pattern>(
						 Arrays.asList(new Pattern[]{
								 Pattern.compile("text/xml")
						})
				)
		 );
		 HashMap<String, String> descriptions = new HashMap<String, String>();
		 descriptions.put("en", "The items instances to project");
		 descriptor.setDescriptions(descriptions);
		 descriptor.setMandatory(true);
		 descriptor.setPossibleValuesRegex(null);
		 inputDescriptors.add(descriptor);
		 return inputDescriptors;
		
	}


	/**
     * @throws XtentisException
     *
     * @ejb.interface-method view-type = "local"
     * @ejb.facade-method
     */
	public ArrayList<TransformerPluginVariableDescriptor> getOutputVariableDescriptors(
			String twoLettersLanguageCode) throws XtentisException {
		 ArrayList<TransformerPluginVariableDescriptor> outputDescriptors = new ArrayList<TransformerPluginVariableDescriptor>();

		 //The output descriptor
		 TransformerPluginVariableDescriptor descriptor = new TransformerPluginVariableDescriptor();
		 descriptor.setVariableName(OUTPUT_TEXT);
		 descriptor.setContentTypesRegex(
				 new ArrayList<Pattern>(
						 Arrays.asList(new Pattern[]{
								 Pattern.compile("text/.*")
						})
				)
		 );
		 HashMap<String, String> descriptions = new HashMap<String, String>();
		 descriptions.put("en", "The number of items which have been projected successfully");
		 descriptor.setDescriptions(descriptions);
		 descriptor.setMandatory(true);
		 descriptor.setPossibleValuesRegex(null);
		 outputDescriptors.add(descriptor);

		 return outputDescriptors;
	}
	
	/**
     * @throws XtentisException
     *
     * @ejb.interface-method view-type = "local"
     * @ejb.facade-method
     */
	public String getParametersSchema() throws XtentisException {
		// Is this feature in use now?
		return
		"<xsd:schema" +
		" 		elementFormDefault='unqualified'" +
		"		xmlns:xsd='http://www.w3.org/2001/XMLSchema'" +
		">" +
		"<xsd:element name='parameters'>" +
		"			<xsd:complexType >" +
		"				<xsd:sequence>" +
		"					<xsd:element minOccurs='1' maxOccurs='1' nillable='false' name='dataClusterName' type='xsd:string'/>" +
		"					<xsd:element minOccurs='1' maxOccurs='1' nillable='false' name='dataModelName' type='xsd:string'/>" +
		"					<xsd:element minOccurs='1' maxOccurs='1' nillable='false' name='conceptName' type='xsd:string'/>" +
		"				</xsd:sequence>" +
		"			</xsd:complexType>" +
		"</xsd:element>"+
		"</xsd:schema>";

	}

	/**
     * @throws XtentisException
     *
     * @ejb.interface-method view-type = "local"
     * @ejb.facade-method
     */
	public String compileParameters(String parameters) throws XtentisException {
		try {
					
			if(parameters==null||parameters.length()==0)return "";
			
    		CompiledParameters compiled = new CompiledParameters();
    		Element params = Util.parse(parameters).getDocumentElement();
    		
    		//mandatory case
			String dataClusterName = Util.getFirstTextNode(params, "dataClusterName");
			if (dataClusterName==null||dataClusterName.length()==0) {
				String err = "The dataClusterName parameter of the BatchProject Transformer Plugin cannot be empty";
				org.apache.log4j.Logger.getLogger(this.getClass()).error(err);
				throw new XtentisException(err);
			}
    		compiled.setDataClusterName(dataClusterName);
    		
    		String dataModelName = Util.getFirstTextNode(params, "dataModelName");
			if (dataModelName==null||dataModelName.length()==0) {
				String err = "The dataModelName parameter of the BatchProject Transformer Plugin cannot be empty";
				org.apache.log4j.Logger.getLogger(this.getClass()).error(err);
				throw new XtentisException(err);
			}
    		compiled.setDataModelName(dataModelName);
    		
    		String conceptName = Util.getFirstTextNode(params, "conceptName");
			if (conceptName==null||conceptName.length()==0) {
				String err = "The conceptName parameter of the BatchProject Transformer Plugin cannot be empty";
				org.apache.log4j.Logger.getLogger(this.getClass()).error(err);
				throw new XtentisException(err);
			}
    		compiled.setConceptName(conceptName);

    		return compiled.serialize();
    		
    	} catch (XtentisException e) {
    		throw(e);
	    } catch (Exception e) {
    	    String err = "Unable to serialize the configuration of the BatchProject Plugin"
    	    		+": "+e.getClass().getName()+": "+e.getLocalizedMessage();
    	    org.apache.log4j.Logger.getLogger(this.getClass()).error(err,e);
    	    throw new XtentisException(err);
	    }
	}

	

	/**
     * @throws XtentisException
     *
     * @ejb.interface-method view-type = "local"
     * @ejb.facade-method
     */
	public void init(TransformerPluginContext context, String compiledParameters)
			throws XtentisException {

		try {
			if (!configurationLoaded) loadConfiguration();

			//parse parameters
			CompiledParameters parameters=CompiledParameters.deserialize(compiledParameters);	

			context.put(PARAMETERS, parameters);
			
		} catch (XtentisException xe) {
			throw (xe);
		} catch (Exception e) {
			String err = "Could not init the BatchProject plugin:"+
				e.getClass().getName()+": "+e.getLocalizedMessage();
			org.apache.log4j.Logger.getLogger(this.getClass()).error(err,e);
			throw new XtentisException(e);
		}
		
	}
	
	/**
     * @throws XtentisException
     *
     * @ejb.interface-method view-type = "local"
     * @ejb.facade-method
     */
	public void execute(TransformerPluginContext context)
			throws XtentisException {
		org.apache.log4j.Logger.getLogger(this.getClass()).debug("execute() BatchProject");	
		try {
			CompiledParameters parameters= (CompiledParameters)context.get(PARAMETERS);
			TypedContent xmlTC = (TypedContent)context.get(INPUT_XML);
			
			//attempt to read charset
			String charset =  Util.extractCharset(xmlTC.getContentType());
			String xml = new String(xmlTC.getContentBytes(),charset);
			
			
			//TODO main process
			String resultText="";
			resultText+=xml;
			
		    context.put(OUTPUT_TEXT, new TypedContent(resultText.getBytes(),"UTF-8"));
			//call the callback content is ready
			context.getPluginCallBack().contentIsReady(context);
			

		} catch (XtentisException xe) {
			throw (xe);
		} catch (Exception e) {
			String err = "Could not execute the BatchProject plugin "+
				e.getClass().getName()+": "+e.getLocalizedMessage();
			org.apache.log4j.Logger.getLogger(this.getClass()).error(err,e);
			throw new XtentisException(e);
		}
		org.apache.log4j.Logger.getLogger(this.getClass()).trace("execute() BatchProject done");
	}

//	@Override
//	public void end(TransformerPluginContext context) throws XtentisException {
//		// TODO release connect etc.
//		super.end(context);
//	}
	
	private String getDefaultConfiguration(){
    	return
    		"<configuration>"+
    		"		<dataClusterName>Order</dataClusterName>" +"\n"+
    		"		<dataModelName>Order</dataModelName>" +"\n"+
    		"		<conceptName>Customer</conceptName>" +"\n"+
			"</configuration>";
    }

	/**
     * @throws XtentisException
     *
     * @ejb.interface-method view-type = "local"
     * @ejb.facade-method
     */
    public String getConfiguration(String optionalParameters) throws XtentisException{
    	try {
    		String configuration = loadConfiguration();
    		if (configuration == null) {
    			configuration = getDefaultConfiguration();
    		}
    		configurationLoaded = true;
    		return configuration;
        } catch (XtentisException e) {
    		throw (e);
	    } catch (Exception e) {
    	    String err = "Unable to deserialize the configuration of the BatchProject Transformer Plugin"
    	    		+": "+e.getClass().getName()+": "+e.getLocalizedMessage();
    	    org.apache.log4j.Category.getInstance(this.getClass()).error(err);
    	    throw new XtentisException(err);
	    }
    }

    /**
     * @throws XtentisException
     *
     * @ejb.interface-method view-type = "local"
     * @ejb.facade-method
     */
	public void putConfiguration(String configuration) throws XtentisException {
		configurationLoaded = false;
		super.putConfiguration(configuration);
	}

	


}