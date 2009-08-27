/*
 * Generated by XDoclet - Do not edit!
 */
package com.amalto.core.ejb.local;

/**
 * Local interface for XmlServerSLWrapper.
 * @xdoclet-generated at 13-08-09
 * @copyright The XDoclet Team
 * @author XDoclet
 * @version ${version}
 */
public interface XmlServerSLWrapperLocal
   extends javax.ejb.EJBLocalObject
{
   /**
    * Is the server up?
    */
   public boolean isUpAndRunning(  ) ;

   /**
    * Get all clusters for a particular revision
    * @param revisionID The ID of the revision, <code>null</code> for the head
    * @return the list of cluster IDs
    */
   public java.lang.String[] getAllClusters( java.lang.String revisionID ) throws com.amalto.core.util.XtentisException;

   /**
    * Delete a cluster for particular revision
    * @param revisionID The ID of the revision, <code>null</code> for the head
    * @param clusterName The name of the cluster
    * @return the milliseconds to perform the operation
    */
   public long deleteCluster( java.lang.String revisionID,java.lang.String clusterName ) throws com.amalto.core.util.XtentisException;

   /**
    * Delete All clusters for a particular revision
    * @param revisionID The ID of the revision, <code>null</code> for the head
    * @return the milliseconds to perform the operation
    */
   public long deleteAllclusterNames( java.lang.String revisionID ) throws com.amalto.core.util.XtentisException;

   /**
    * Create a cluster for a particular revision
    * @param revisionID The ID of the revision, <code>null</code> for the head
    * @param clusterName The name of the cluster
    * @return the milliseconds to perform the operation
    */
   public long createCluster( java.lang.String revisionID,java.lang.String clusterName ) throws com.amalto.core.util.XtentisException;

   /**
    * Reads a document from a file and stores it in the DB
    * @param fileName The full path of the file
    * @param uniqueID The unique ID of the document
    * @param clusterName The unique ID of the cluster
    * @param revisionID The ID of the revision, <code>null</code> for the head
    * @return the milliseconds to perform the operation
    */
   public long putDocumentFromFile( java.lang.String fileName,java.lang.String uniqueID,java.lang.String clusterName,java.lang.String revisionID ) throws com.amalto.core.util.XtentisException;

   /**
    * Reads a document from a file and stores it in the DB
    * @param fileName The full path of the file
    * @param uniqueID The unique ID of the document
    * @param clusterName The unique ID of the cluster
    * @param revisionID The ID of the revision, <code>null</code> for the head
    * @param documentType="DOCUMENT"
    * @return the milliseconds to perform the operation
    */
   public long putDocumentFromFile( java.lang.String fileName,java.lang.String uniqueID,java.lang.String clusterName,java.lang.String revisionID,java.lang.String documentType ) throws com.amalto.core.util.XtentisException;

   /**
    * Read a document from s String an store it in the DB as "DOCUMENT"
    * @param xmlString The xml string
    * @param uniqueID The unique ID of the document
    * @param clusterName The unique ID of the cluster
    * @param revisionID The ID of the revision, <code>null</code> for the head
    * @return the time to store the document
    */
   public long putDocumentFromString( java.lang.String xmlString,java.lang.String uniqueID,java.lang.String clusterName,java.lang.String revisionID ) throws com.amalto.core.util.XtentisException;

   /**
    * Read a document from a String and store it in the DB
    * @param string The string to store
    * @param uniqueID The unique ID of the document
    * @param clusterName The unique ID of the cluster
    * @param revisionID The ID of the revision, <code>null</code> for the head
    * @param documentType="DOCUMENT"
    * @return the time to store the document
    */
   public long putDocumentFromString( java.lang.String string,java.lang.String uniqueID,java.lang.String clusterName,java.lang.String revisionID,java.lang.String documentType ) throws com.amalto.core.util.XtentisException;

   /**
    * Stores a document from its DOM root element
    * @param root The DOM root element
    * @param uniqueID The unique ID of the document
    * @param clusterName The unique ID of the cluster
    * @param revisionID The ID of the revision, <code>null</code> for the head
    * @return the time to store the document
    */
   public long putDocumentFromDOM( org.w3c.dom.Element root,java.lang.String uniqueID,java.lang.String clusterName,java.lang.String revisionID ) throws com.amalto.core.util.XtentisException;

   /**
    * Gets an XML document from the DB<br> The XML instruction will have an encoding specified as UTF-16
    * @param uniqueID The unique ID of the document
    * @param clusterName The unique ID of the cluster
    * @param revisionID The ID of the revision, <code>null</code> for the head
    * @return the document as A string
    */
   public java.lang.String getDocumentAsString( java.lang.String revisionID,java.lang.String clusterName,java.lang.String uniqueID ) throws com.amalto.core.util.XtentisException;

   /**
    * Gets an XML document from the DB<br> The XML instruction will have the encoding specified in the encoding parameter<br> If encoding is null, the document will not have an XML instruction
    * @param uniqueID The unique ID of the document
    * @param clusterName The unique ID of the cluster
    * @param revisionID The ID of the revision, <code>null</code> for the head
    * @param encoding The encoding of the XML instruction (e.g. UTF-16, UTF-8, etc...).
    * @return the document as A string
    */
   public java.lang.String getDocumentAsString( java.lang.String revisionID,java.lang.String clusterName,java.lang.String uniqueID,java.lang.String encoding ) throws com.amalto.core.util.XtentisException;

   /**
    * Gets the bytes of a document from the DB<br> For an xml "DOCUMENT" type, the bytes will be encoded using UTF-16 The XML instruction will have an encoding specified as UTF-16
    * @param uniqueID The unique ID of the document
    * @param clusterName The unique ID of the cluster
    * @param revisionID The ID of the revision, <code>null</code> for the head
    * @param documentType="DOCUMENT"
    * @return the document as A string
    */
   public byte[] getDocumentBytes( java.lang.String revisionID,java.lang.String clusterName,java.lang.String uniqueID,java.lang.String documentType ) throws com.amalto.core.util.XtentisException;

   /**
    * The list of documents unique ids in a cluster of a particular revision
    * @param clusterName The unique ID of the cluster
    * @param revisionID The ID of the revision, <code>null</code> for the head
    * @return the list of document unique IDs
    */
   public java.lang.String[] getAllDocumentsUniqueID( java.lang.String revisionID,java.lang.String clusterName ) throws com.amalto.core.util.XtentisException;

   /**
    * Delete an XML document
    * @param uniqueID The unique ID of the document
    * @param clusterName The unique ID of the cluster
    * @param revisionID The ID of the revision, <code>null</code> for the head
    * @return the time to perform the delete
    */
   public long deleteDocument( java.lang.String revisionID,java.lang.String clusterName,java.lang.String uniqueID ) throws com.amalto.core.util.XtentisException;

   /**
    * Delete a document
    * @param uniqueID The unique ID of the document
    * @param clusterName The unique ID of the cluster
    * @param revisionID The ID of the revision, <code>null</code> for the head
    * @return the time to perform the delete
    */
   public long deleteDocument( java.lang.String revisionID,java.lang.String clusterName,java.lang.String uniqueID,java.lang.String documentType ) throws com.amalto.core.util.XtentisException;

   /**
    * Delete Xtentis Objects matching a particular condition<br>
    * @param objectRootElementNameToRevisionID A map that gives the revision ID of an Object XML Root Element Name
    * @param objectRootElementNameToClusterName An ordered map that gives the cluster name of an Object XML Root Element Name
    * @param objectRootElementName The objectType (its name)
    * @param whereItem The condition
    * @return the number of items deleted
    */
   public int deleteXtentisObjects( java.util.HashMap objectRootElementNameToRevisionID,java.util.HashMap objectRootElementNameToClusterName,java.lang.String objectRootElementName,com.amalto.xmlserver.interfaces.IWhereItem whereItem ) throws com.amalto.core.util.XtentisException;

   /**
    * Delete Items matching a particular condition<br>
    * @param conceptPatternsToClusterName An ordered map that gives the cluster name of a Concept when matching the first pattern found
    * @param conceptPatternsToRevisionID An ordered map that gives the revision ID of a Concept when matching the first pattern found
    * @param conceptName The Concept of the items being deleted
    * @param whereItem The condition
    * @return the number of items deleted
    */
   public int deleteItems( java.util.LinkedHashMap conceptPatternsToRevisionID,java.util.LinkedHashMap conceptPatternsToClusterName,java.lang.String conceptName,com.amalto.xmlserver.interfaces.IWhereItem whereItem ) throws com.amalto.core.util.XtentisException;

   /**
    * Move a document between two clusters of particular revision
    * @param uniqueID The unique ID of the document
    * @param sourceclusterName The unique ID of the source cluster
    * @param sourceRevisionID The ID of the source revision
    * @param targetclusterName The unique ID of the target cluster
    * @param targetRevisionID The ID of the target revision
    * @return the time to perform the move
    */
   public long moveDocumentById( java.lang.String sourceRevisionID,java.lang.String sourceclusterName,java.lang.String uniqueID,java.lang.String targetRevisionID,java.lang.String targetclusterName ) throws com.amalto.core.util.XtentisException;

   /**
    * Count Items based on conditions
    * @param conceptPatternsToRevisionID A map that gives the revision ID of a pattern matching a concept name Concept (isItemQuery is true) or Xtentis Object (isItemQuery is false)
    * @param conceptPatternsToClusterName An ordered map that gives the cluster name of a Concept when matching the first pattern found
    * @param conceptName The name of the concept
    * @param whereItem The condition to apply
    * @return the number of items meeting the conditions
    * @throws XtentisException
    */
   public long countItems( java.util.LinkedHashMap conceptPatternsToRevisionID,java.util.LinkedHashMap conceptPatternsToClusterName,java.lang.String conceptName,com.amalto.xmlserver.interfaces.IWhereItem whereItem ) throws com.amalto.core.util.XtentisException;

   /**
    * Count Xtentis Objects based on conditions
    * @param objectRootElementNameToRevisionID A map that gives the revision ID of an Xtentis Object based on its XML Root Element Name
    * @param objectRootElementNameToClusterName An ordered map that gives the cluster name of an Object based on its XML Root Element Name
    * @param mainObjectRootElementName An optional object XML root element name that will serve as the main pivot<br/> If not specified, the pivots will be in ordered of those in the viewableBusinessElements
    * @param whereItem The condition to apply
    * @return the number of items meeting the conditions
    * @throws XtentisException
    */
   public long countXtentisObjects( java.util.HashMap objectRootElementNameToRevisionID,java.util.HashMap objectRootElementNameToClusterName,java.lang.String mainObjectRootElementName,com.amalto.xmlserver.interfaces.IWhereItem whereItem ) throws com.amalto.core.util.XtentisException;

   /**
    * Performs a query on the db with optional parameters<br> The parameters are specified as %n in the query where n is the parameter number starting with 0
    * @param revisionID The ID of the revision, <code>null</code> to run from the head
    * @param clusterName The unique ID of the cluster, <code>null</code> to run from the head of the revision ID
    * @param query The query in the native language
    * @param parameters The parameter values to replace the %n in the query before execution
    * @return the result of the Query as a Collection of Strings
    */
   public java.util.ArrayList runQuery( java.lang.String revisionID,java.lang.String clusterName,java.lang.String query,java.lang.String[] parameters ) throws com.amalto.core.util.XtentisException;

   /**
    * Builds a query in the native language of the DB (for instance XQuery) based on conditions
    * @param objectRootElementNameToRevisionID A map that gives the revision ID of an Object XML Root Element Name
    * @param objectRootElementNameToClusterName An ordered map that gives the cluster name of an Object XML Root Element Name
    * @param viewableObjectElements The full XPath (starting with the Object root element name) of the elements and their sub elements that constitute the top elements of the returned documents
    * @param mainObjectRootElementName An optional object type that will serve as the main pivot<br/> If not specified, the pivots will be in ordered of those in the viewableObjectElements
    * @param whereItem The condition to apply
    * @param orderBy The path of the element to order by. <code>null</code> to avoid ordering
    * @param direction If orderBy is not <code>null</code>, the direction. One of
    * @param start The index of the first element to return (start at 0)
    * @param limit The index of the last element to search. A negative value or {@value Integer#MAX_VALUE} means no limit
    * @return the XQuery in the native language of the database
    * @throws XtentisException
    */
   public java.lang.String getXtentisObjectsQuery( java.util.HashMap objectRootElementNameToRevisionID,java.util.HashMap objectRootElementNameToClusterName,java.lang.String mainObjectRootElementName,java.util.ArrayList viewableObjectElements,com.amalto.xmlserver.interfaces.IWhereItem whereItem,java.lang.String orderBy,java.lang.String direction,int start,int limit ) throws com.amalto.core.util.XtentisException;

   /**
    * Builds an Items query in the native language of the DB (for instance XQuery) based on conditions
    * @param conceptPatternsToRevisionID A map that gives the revision ID of a pattern matching a concept name Concept (isItemQuery is true) or Xtentis Object (isItemQuery is false)
    * @param conceptPatternsToClusterName An ordered map that gives the cluster name of a Concept when matching the first pattern found
    * @param forceMainPivot An optional pivot that will appear first in the list of pivots in the query<br>: This allows forcing cartesian products: for instance Order Header vs Order Line
    * @param viewableFullPaths The Full xPaths (starting with concept name) of the elements and their sub elements that constitute the top elements of the returned documents
    * @param whereItem The condition to apply
    * @param orderBy The path of the element to order by. <code>null</code> to avoid ordering
    * @param direction If orderBy is not <code>null</code>, the direction. One of
    * @param start The index of the first element to return (start at 0)
    * @param limit The index of the last element to search. A negative value or {@value Integer#MAX_VALUE} means no limit
    * @param spellThreshold Spell check the whereItem if threshold is greater than zero. The setting is ignored is this not an item query.
    * @return the xquery in the native language of the db
    */
   public java.lang.String getItemsQuery( java.util.LinkedHashMap conceptPatternsToRevisionID,java.util.LinkedHashMap conceptPatternsToClusterName,java.lang.String forceMainPivot,java.util.ArrayList viewableFullPaths,com.amalto.xmlserver.interfaces.IWhereItem whereItem,java.lang.String orderBy,java.lang.String direction,int start,int limit,int spellThreshold ) throws com.amalto.core.util.XtentisException;

   public java.lang.String getPivotIndexQuery( java.lang.String clusterName,java.lang.String mainPivotName,java.util.LinkedHashMap pivotWithKeys,java.lang.String[] indexPaths,com.amalto.xmlserver.interfaces.IWhereItem whereItem,java.lang.String[] pivotDirections,java.lang.String[] indexDirections,int start,int limit ) throws com.amalto.core.util.XtentisException;

}