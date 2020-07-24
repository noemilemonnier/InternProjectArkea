package com.arkea.com.arkea.commons.archetypes.server.dao.host.tn00pr0.copy;
import com.ibm.record.*;
import com.ibm.record.util.bidi.*;
import java.io.*;
/**
 * Class: com.arkea.com.arkea.commons.archetypes.server.dao.host.tn00pr0.copy.Y00PR0IR_Y00PR0__ZON__APLI__RE__Y00PR0__ZON__APLI__RE__LS_Y00PR0__LIG
 * This is a generated file.  Do not edit.
 */


public class Y00PR0IR_Y00PR0__ZON__APLI__RE__Y00PR0__ZON__APLI__RE__LS_Y00PR0__LIG extends com.ibm.record.CustomRecord implements java.io.Serializable
{

      private static Y00PR0IR_Y00PR0__ZON__APLI__RE__Y00PR0__ZON__APLI__RE__LS_Y00PR0__LIG initialRecord = new Y00PR0IR_Y00PR0__ZON__APLI__RE__Y00PR0__ZON__APLI__RE__LS_Y00PR0__LIG();

   public Y00PR0IR_Y00PR0__ZON__APLI__RE__Y00PR0__ZON__APLI__RE__LS_Y00PR0__LIG()
      throws RecordException
   {
      try {
         if (this.initialRecord == null) {
            com.ibm.ivj.eab.record.cobol.CobolRecordAttributes attrs = new com.ibm.ivj.eab.record.cobol.CobolRecordAttributes();
            attrs.setCodePage("8859_1");
            attrs.setEndian(1);
            attrs.setFloatingPointFormat(1);
            attrs.setMachine(com.ibm.ivj.eab.record.cobol.CobolRecordAttributes.NT);
            attrs.setRemoteIntEndian(1);
            this.setRecordAttributes(attrs);
            this.setRecordType(new CustomRecordType(com.arkea.com.arkea.commons.archetypes.server.dao.host.tn00pr0.copy.Y00PR0IR_Y00PR0__ZON__APLI__RE__Y00PR0__ZON__APLI__RE__LS_Y00PR0__LIG.class,86));
            this.setRawBytes(new byte[86]);
            this.setInitialValues();
         } else {
            this.setRecordAttributes((com.ibm.ivj.eab.record.cobol.CobolRecordAttributes)this.initialRecord.getRecordAttributes().clone());
            this.setRecordType(this.initialRecord.getRecordType());
            this.setRawBytes(new byte[86]);
            System.arraycopy(this.initialRecord.getRawBytes(),0,this.getRawBytes(),0,86);
         }
      } catch (Exception e) {
         throw new RecordException(e.getMessage());
      }
   }

   public Y00PR0IR_Y00PR0__ZON__APLI__RE__Y00PR0__ZON__APLI__RE__LS_Y00PR0__LIG(byte[] byteArray)
      throws RecordException
   {
      try {
         if (this.initialRecord == null) {
            com.ibm.ivj.eab.record.cobol.CobolRecordAttributes attrs = new com.ibm.ivj.eab.record.cobol.CobolRecordAttributes();
            attrs.setCodePage("8859_1");
            attrs.setEndian(1);
            attrs.setFloatingPointFormat(1);
            attrs.setMachine(com.ibm.ivj.eab.record.cobol.CobolRecordAttributes.NT);
            attrs.setRemoteIntEndian(1);
            this.setRecordAttributes(attrs);
            this.setRecordType(new CustomRecordType(com.arkea.com.arkea.commons.archetypes.server.dao.host.tn00pr0.copy.Y00PR0IR_Y00PR0__ZON__APLI__RE__Y00PR0__ZON__APLI__RE__LS_Y00PR0__LIG.class,86));
            this.setRawBytes(byteArray);
         } else {
            this.setRecordAttributes((com.ibm.ivj.eab.record.cobol.CobolRecordAttributes)this.initialRecord.getRecordAttributes().clone());
            this.setRecordType(this.initialRecord.getRecordType());
            this.setRawBytes(byteArray);
         }
      } catch (Exception e) {
         throw new RecordException(e.getMessage());
      }
   }

   public java.lang.String getY00pr0__Cd__Efs__Lst()
      throws RecordConversionFailureException {
      return com.ibm.ivj.eab.record.cobol.CobolType.toString(this,0,9,0,2,false,false,false,-1,0,"X(2)",false,true);
   }
   public void setY00pr0__Cd__Efs__Lst(java.lang.String aY00pr0__Cd__Efs__Lst)
      throws RecordConversionFailureException {
      com.ibm.ivj.eab.record.cobol.CobolType.fromString(this,0,aY00pr0__Cd__Efs__Lst,9,0,2,false,false,false,-1,0,"X(2)",false,true);
      return;
   }
   public java.lang.String getY00pr0__Cd__Apli__Ls()
      throws RecordConversionFailureException {
      return com.ibm.ivj.eab.record.cobol.CobolType.toString(this,2,9,0,2,false,false,false,-1,0,"X(2)",false,true);
   }
   public void setY00pr0__Cd__Apli__Ls(java.lang.String aY00pr0__Cd__Apli__Ls)
      throws RecordConversionFailureException {
      com.ibm.ivj.eab.record.cobol.CobolType.fromString(this,2,aY00pr0__Cd__Apli__Ls,9,0,2,false,false,false,-1,0,"X(2)",false,true);
      return;
   }
   public java.lang.String getY00pr0__No__Seq__Ls()
      throws RecordConversionFailureException {
      return com.ibm.ivj.eab.record.cobol.CobolType.toString(this,4,9,0,6,false,false,false,-5,0,"X(6)",false,true);
   }
   public void setY00pr0__No__Seq__Ls(java.lang.String aY00pr0__No__Seq__Ls)
      throws RecordConversionFailureException {
      com.ibm.ivj.eab.record.cobol.CobolType.fromString(this,4,aY00pr0__No__Seq__Ls,9,0,6,false,false,false,-5,0,"X(6)",false,true);
      return;
   }
   public java.lang.String getY00pr0__Tm__Stp__Ls()
      throws RecordConversionFailureException {
      return com.ibm.ivj.eab.record.cobol.CobolType.toString(this,10,9,0,26,false,false,false,-25,0,"X(26)",false,true);
   }
   public void setY00pr0__Tm__Stp__Ls(java.lang.String aY00pr0__Tm__Stp__Ls)
      throws RecordConversionFailureException {
      com.ibm.ivj.eab.record.cobol.CobolType.fromString(this,10,aY00pr0__Tm__Stp__Ls,9,0,26,false,false,false,-25,0,"X(26)",false,true);
      return;
   }
   public java.lang.String getY00pr0__Wk__Zon__Par__Ls()
      throws RecordConversionFailureException {
      return com.ibm.ivj.eab.record.cobol.CobolType.toString(this,36,9,0,50,false,false,false,-49,0,"X(50)",false,true);
   }
   public void setY00pr0__Wk__Zon__Par__Ls(java.lang.String aY00pr0__Wk__Zon__Par__Ls)
      throws RecordConversionFailureException {
      com.ibm.ivj.eab.record.cobol.CobolType.fromString(this,36,aY00pr0__Wk__Zon__Par__Ls,9,0,50,false,false,false,-49,0,"X(50)",false,true);
      return;
   }

   public void setInitialValues() throws
      RecordConversionFailureException,
      RecordConversionUnsupportedException
   {
      com.ibm.ivj.eab.record.cobol.CobolType.fromStringInitialValue(this,0, new com.ibm.ivj.eab.record.cobol.CobolInitialValueObject(" ,null"),9,0,2,false,false,false,-1,0,"X(2)",false,true);
      com.ibm.ivj.eab.record.cobol.CobolType.fromStringInitialValue(this,2, new com.ibm.ivj.eab.record.cobol.CobolInitialValueObject(" ,null"),9,0,2,false,false,false,-1,0,"X(2)",false,true);
      com.ibm.ivj.eab.record.cobol.CobolType.fromStringInitialValue(this,4, new com.ibm.ivj.eab.record.cobol.CobolInitialValueObject(" ,null"),9,0,6,false,false,false,-5,0,"X(6)",false,true);
      com.ibm.ivj.eab.record.cobol.CobolType.fromStringInitialValue(this,10, new com.ibm.ivj.eab.record.cobol.CobolInitialValueObject(" ,null"),9,0,26,false,false,false,-25,0,"X(26)",false,true);
      com.ibm.ivj.eab.record.cobol.CobolType.fromStringInitialValue(this,36, new com.ibm.ivj.eab.record.cobol.CobolInitialValueObject(" ,null"),9,0,50,false,false,false,-49,0,"X(50)",false,true);
      return;
   }

}
/**
 * This is a generated file.  Do not edit.
 */
