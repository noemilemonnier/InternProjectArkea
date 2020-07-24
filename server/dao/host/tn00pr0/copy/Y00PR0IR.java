package com.arkea.com.arkea.commons.archetypes.server.dao.host.tn00pr0.copy;
import com.ibm.record.*;
import com.ibm.record.util.bidi.*;
import java.io.*;
/**
 * Class: com.arkea.com.arkea.commons.archetypes.server.dao.host.tn00pr0.copy.Y00PR0IR
 * This is a generated file.  Do not edit.
 */


public class Y00PR0IR extends com.ibm.record.CustomRecord implements java.io.Serializable
{

      private static Y00PR0IR initialRecord = new Y00PR0IR();

   public Y00PR0IR()
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
            this.setRecordType(new CustomRecordType(com.arkea.com.arkea.commons.archetypes.server.dao.host.tn00pr0.copy.Y00PR0IR.class,9155));
            this.setRawBytes(new byte[9155]);
            this.setInitialValues();
         } else {
            this.setRecordAttributes((com.ibm.ivj.eab.record.cobol.CobolRecordAttributes)this.initialRecord.getRecordAttributes().clone());
            this.setRecordType(this.initialRecord.getRecordType());
            this.setRawBytes(new byte[9155]);
            System.arraycopy(this.initialRecord.getRawBytes(),0,this.getRawBytes(),0,9155);
         }
      } catch (Exception e) {
         throw new RecordException(e.getMessage());
      }
   }

   public Y00PR0IR(byte[] byteArray)
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
            this.setRecordType(new CustomRecordType(com.arkea.com.arkea.commons.archetypes.server.dao.host.tn00pr0.copy.Y00PR0IR.class,9155));
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

   public java.lang.String getY00pr0__Cd__Efs__Al()
      throws RecordConversionFailureException {
      return com.ibm.ivj.eab.record.cobol.CobolType.toString(this,0,9,0,2,false,false,false,-1,0,"X(2)",false,true);
   }
   public void setY00pr0__Cd__Efs__Al(java.lang.String aY00pr0__Cd__Efs__Al)
      throws RecordConversionFailureException {
      com.ibm.ivj.eab.record.cobol.CobolType.fromString(this,0,aY00pr0__Cd__Efs__Al,9,0,2,false,false,false,-1,0,"X(2)",false,true);
      return;
   }
   public java.lang.String getY00pr0__Cd__Apli__Al()
      throws RecordConversionFailureException {
      return com.ibm.ivj.eab.record.cobol.CobolType.toString(this,2,9,0,2,false,false,false,-1,0,"X(2)",false,true);
   }
   public void setY00pr0__Cd__Apli__Al(java.lang.String aY00pr0__Cd__Apli__Al)
      throws RecordConversionFailureException {
      com.ibm.ivj.eab.record.cobol.CobolType.fromString(this,2,aY00pr0__Cd__Apli__Al,9,0,2,false,false,false,-1,0,"X(2)",false,true);
      return;
   }
   public java.lang.String getY00pr0__No__Seq__Al()
      throws RecordConversionFailureException {
      return com.ibm.ivj.eab.record.cobol.CobolType.toString(this,4,9,0,6,false,false,false,-5,0,"X(6)",false,true);
   }
   public void setY00pr0__No__Seq__Al(java.lang.String aY00pr0__No__Seq__Al)
      throws RecordConversionFailureException {
      com.ibm.ivj.eab.record.cobol.CobolType.fromString(this,4,aY00pr0__No__Seq__Al,9,0,6,false,false,false,-5,0,"X(6)",false,true);
      return;
   }
   public java.lang.String getY00pr0__Idt__Uti__Al()
      throws RecordConversionFailureException {
      return com.ibm.ivj.eab.record.cobol.CobolType.toString(this,10,9,0,8,false,false,false,-7,0,"X(8)",false,true);
   }
   public void setY00pr0__Idt__Uti__Al(java.lang.String aY00pr0__Idt__Uti__Al)
      throws RecordConversionFailureException {
      com.ibm.ivj.eab.record.cobol.CobolType.fromString(this,10,aY00pr0__Idt__Uti__Al,9,0,8,false,false,false,-7,0,"X(8)",false,true);
      return;
   }
   public java.lang.String getY00pr0__Idc__Repr__Al()
      throws RecordConversionFailureException {
      return com.ibm.ivj.eab.record.cobol.CobolType.toString(this,18,9,0,1,false,false,false,0,0,"X(1)",false,true);
   }
   public void setY00pr0__Idc__Repr__Al(java.lang.String aY00pr0__Idc__Repr__Al)
      throws RecordConversionFailureException {
      com.ibm.ivj.eab.record.cobol.CobolType.fromString(this,18,aY00pr0__Idc__Repr__Al,9,0,1,false,false,false,0,0,"X(1)",false,true);
      return;
   }
   public java.lang.String getFill_0()
      throws RecordConversionFailureException {
      return com.ibm.ivj.eab.record.cobol.CobolType.toString(this,19,9,0,1,false,false,false,0,0,"X(1)",false,true);
   }
   public void setFill_0(java.lang.String aFill_0)
      throws RecordConversionFailureException {
      com.ibm.ivj.eab.record.cobol.CobolType.fromString(this,19,aFill_0,9,0,1,false,false,false,0,0,"X(1)",false,true);
      return;
   }
   public java.lang.String getY00pr0__Cd__Efs()
      throws RecordConversionFailureException {
      return com.ibm.ivj.eab.record.cobol.CobolType.toString(this,20,9,0,2,false,false,false,-1,0,"X(2)",false,true);
   }
   public void setY00pr0__Cd__Efs(java.lang.String aY00pr0__Cd__Efs)
      throws RecordConversionFailureException {
      com.ibm.ivj.eab.record.cobol.CobolType.fromString(this,20,aY00pr0__Cd__Efs,9,0,2,false,false,false,-1,0,"X(2)",false,true);
      return;
   }
   public java.lang.String getY00pr0__Cd__Apl()
      throws RecordConversionFailureException {
      return com.ibm.ivj.eab.record.cobol.CobolType.toString(this,22,9,0,2,false,false,false,-1,0,"X(2)",false,true);
   }
   public void setY00pr0__Cd__Apl(java.lang.String aY00pr0__Cd__Apl)
      throws RecordConversionFailureException {
      com.ibm.ivj.eab.record.cobol.CobolType.fromString(this,22,aY00pr0__Cd__Apl,9,0,2,false,false,false,-1,0,"X(2)",false,true);
      return;
   }
   public java.lang.String getY00pr0__No__Seq()
      throws RecordConversionFailureException {
      return com.ibm.ivj.eab.record.cobol.CobolType.toString(this,24,9,0,6,false,false,false,-5,0,"X(6)",false,true);
   }
   public void setY00pr0__No__Seq(java.lang.String aY00pr0__No__Seq)
      throws RecordConversionFailureException {
      com.ibm.ivj.eab.record.cobol.CobolType.fromString(this,24,aY00pr0__No__Seq,9,0,6,false,false,false,-5,0,"X(6)",false,true);
      return;
   }
   public java.lang.String getY00pr0__Idc__Repr()
      throws RecordConversionFailureException {
      return com.ibm.ivj.eab.record.cobol.CobolType.toString(this,30,9,0,1,false,false,false,0,0,"X(1)",false,true);
   }
   public void setY00pr0__Idc__Repr(java.lang.String aY00pr0__Idc__Repr)
      throws RecordConversionFailureException {
      com.ibm.ivj.eab.record.cobol.CobolType.fromString(this,30,aY00pr0__Idc__Repr,9,0,1,false,false,false,0,0,"X(1)",false,true);
      return;
   }
   public java.lang.String getY00pr0__Wk__Zon__Par()
      throws RecordConversionFailureException {
      return com.ibm.ivj.eab.record.cobol.CobolType.toString(this,31,9,0,250,false,false,false,-249,0,"X(250)",false,true);
   }
   public void setY00pr0__Wk__Zon__Par(java.lang.String aY00pr0__Wk__Zon__Par)
      throws RecordConversionFailureException {
      com.ibm.ivj.eab.record.cobol.CobolType.fromString(this,31,aY00pr0__Wk__Zon__Par,9,0,250,false,false,false,-249,0,"X(250)",false,true);
      return;
   }
   public java.lang.String getY00pr0__Wk__Zon__Par__1()
      throws RecordConversionFailureException {
      return com.ibm.ivj.eab.record.cobol.CobolType.toString(this,281,9,0,250,false,false,false,-249,0,"X(250)",false,true);
   }
   public void setY00pr0__Wk__Zon__Par__1(java.lang.String aY00pr0__Wk__Zon__Par__1)
      throws RecordConversionFailureException {
      com.ibm.ivj.eab.record.cobol.CobolType.fromString(this,281,aY00pr0__Wk__Zon__Par__1,9,0,250,false,false,false,-249,0,"X(250)",false,true);
      return;
   }
   public java.lang.String getY00pr0__Idt__Uti()
      throws RecordConversionFailureException {
      return com.ibm.ivj.eab.record.cobol.CobolType.toString(this,531,9,0,8,false,false,false,-7,0,"X(8)",false,true);
   }
   public void setY00pr0__Idt__Uti(java.lang.String aY00pr0__Idt__Uti)
      throws RecordConversionFailureException {
      com.ibm.ivj.eab.record.cobol.CobolType.fromString(this,531,aY00pr0__Idt__Uti,9,0,8,false,false,false,-7,0,"X(8)",false,true);
      return;
   }
   public java.lang.String getY00pr0__Tm__Stp()
      throws RecordConversionFailureException {
      return com.ibm.ivj.eab.record.cobol.CobolType.toString(this,539,9,0,26,false,false,false,-25,0,"X(26)",false,true);
   }
   public void setY00pr0__Tm__Stp(java.lang.String aY00pr0__Tm__Stp)
      throws RecordConversionFailureException {
      com.ibm.ivj.eab.record.cobol.CobolType.fromString(this,539,aY00pr0__Tm__Stp,9,0,26,false,false,false,-25,0,"X(26)",false,true);
      return;
   }
   public java.lang.String getFill_1()
      throws RecordConversionFailureException {
      return com.ibm.ivj.eab.record.cobol.CobolType.toString(this,565,9,0,8590,false,false,false,-8589,0,"X(8590)",false,true);
   }
   public void setFill_1(java.lang.String aFill_1)
      throws RecordConversionFailureException {
      com.ibm.ivj.eab.record.cobol.CobolType.fromString(this,565,aFill_1,9,0,8590,false,false,false,-8589,0,"X(8590)",false,true);
      return;
   }
   public Y00PR0IR_Y00PR0__ZON__APLI__RE__Y00PR0__ZON__APLI__RE__LS_Y00PR0__LIG getY00pr0__Lig(int index)
      throws RecordConversionFailureException {
      try
      {
         int elementSize = 86;
         int[] dim = {105};
         int offset = 20 + com.ibm.ivj.eab.record.cobol.CobolArrayType.getElementOffset(index,dim,elementSize);
         CustomRecordType returnRecordType = new CustomRecordType(Y00PR0IR_Y00PR0__ZON__APLI__RE__Y00PR0__ZON__APLI__RE__LS_Y00PR0__LIG.class,elementSize);
         CustomRecord returnRecord = (CustomRecord) returnRecordType.newRecord(getRecordAttributes(),0,0);
         byte[] bytes = new byte[elementSize];
         System.arraycopy (getBytes(), offset, bytes, 0, elementSize);
         returnRecord.setBytes (bytes);
         return ((Y00PR0IR_Y00PR0__ZON__APLI__RE__Y00PR0__ZON__APLI__RE__LS_Y00PR0__LIG)returnRecord);
      }
      catch (Exception exc)
      {
         throw new RecordConversionFailureException();
      }
   }
   public void setY00pr0__Lig(int index, Y00PR0IR_Y00PR0__ZON__APLI__RE__Y00PR0__ZON__APLI__RE__LS_Y00PR0__LIG aY00pr0__Lig)
      throws RecordConversionFailureException {
      try
      {
         int elementSize = 86;
         int[] dim = {105};
         int offset = 20 + com.ibm.ivj.eab.record.cobol.CobolArrayType.getElementOffset(index,dim,elementSize);
         byte[] recordBytes = getBytes();
         byte[] fieldBytes = aY00pr0__Lig.getBytes();
         System.arraycopy(fieldBytes,0,recordBytes,offset,fieldBytes.length);
         setBytes(recordBytes);
      }
      catch (Exception exc)
      {
         throw new RecordConversionFailureException();
      }
   }
   public Y00PR0IR_Y00PR0__ZON__APLI__RE__Y00PR0__ZON__APLI__RE__LS_Y00PR0__LIG[] getY00pr0__Lig()
      throws RecordConversionFailureException {
      try
      {
         int elementSize = 86;
         Y00PR0IR_Y00PR0__ZON__APLI__RE__Y00PR0__ZON__APLI__RE__LS_Y00PR0__LIG[] returnArray = new Y00PR0IR_Y00PR0__ZON__APLI__RE__Y00PR0__ZON__APLI__RE__LS_Y00PR0__LIG[105];
         int[] dim = {105};
         for(int i0=0;i0<105;i0++) {
            int offset = 20 + com.ibm.ivj.eab.record.cobol.CobolArrayType.getElementOffset(i0,dim,elementSize);
            CustomRecordType elementRecordType = new CustomRecordType(Y00PR0IR_Y00PR0__ZON__APLI__RE__Y00PR0__ZON__APLI__RE__LS_Y00PR0__LIG.class,elementSize);
            CustomRecord element = (CustomRecord) elementRecordType.newRecord(getRecordAttributes(),0,0);
            byte[] bytes = new byte[elementSize];
            System.arraycopy (getBytes(), offset, bytes, 0, elementSize);
            element.setBytes (bytes);
            returnArray[i0] = (Y00PR0IR_Y00PR0__ZON__APLI__RE__Y00PR0__ZON__APLI__RE__LS_Y00PR0__LIG)element;
         }
         return returnArray;
      }
      catch (Exception exc)
      {
         throw new RecordConversionFailureException();
      }
   }
   public void setY00pr0__Lig(Y00PR0IR_Y00PR0__ZON__APLI__RE__Y00PR0__ZON__APLI__RE__LS_Y00PR0__LIG[] aY00pr0__Lig)
      throws RecordConversionFailureException {
      try
      {
         int elementSize = 86;
         int[] dim = {105};
         for(int i0=0;i0<105;i0++) {
            int offset = 20 + com.ibm.ivj.eab.record.cobol.CobolArrayType.getElementOffset(i0,dim,elementSize);
            byte[] recordBytes = getBytes();
            byte[] fieldBytes = aY00pr0__Lig[i0].getBytes();
            System.arraycopy(fieldBytes,0,recordBytes,offset,fieldBytes.length);
            setBytes(recordBytes);
         }
      }
      catch (Exception exc)
      {
         throw new RecordConversionFailureException();
      }
   }
   public java.lang.String getFill_2()
      throws RecordConversionFailureException {
      return com.ibm.ivj.eab.record.cobol.CobolType.toString(this,9050,9,0,105,false,false,false,-104,0,"X(105)",false,true);
   }
   public void setFill_2(java.lang.String aFill_2)
      throws RecordConversionFailureException {
      com.ibm.ivj.eab.record.cobol.CobolType.fromString(this,9050,aFill_2,9,0,105,false,false,false,-104,0,"X(105)",false,true);
      return;
   }

   public void setInitialValues() throws
      RecordConversionFailureException,
      RecordConversionUnsupportedException
   {
      com.ibm.ivj.eab.record.cobol.CobolType.fromStringInitialValue(this,0, new com.ibm.ivj.eab.record.cobol.CobolInitialValueObject(" ,null"),9,0,2,false,false,false,-1,0,"X(2)",false,true);
      com.ibm.ivj.eab.record.cobol.CobolType.fromStringInitialValue(this,2, new com.ibm.ivj.eab.record.cobol.CobolInitialValueObject(" ,null"),9,0,2,false,false,false,-1,0,"X(2)",false,true);
      com.ibm.ivj.eab.record.cobol.CobolType.fromStringInitialValue(this,4, new com.ibm.ivj.eab.record.cobol.CobolInitialValueObject(" ,null"),9,0,6,false,false,false,-5,0,"X(6)",false,true);
      com.ibm.ivj.eab.record.cobol.CobolType.fromStringInitialValue(this,10, new com.ibm.ivj.eab.record.cobol.CobolInitialValueObject(" ,null"),9,0,8,false,false,false,-7,0,"X(8)",false,true);
      com.ibm.ivj.eab.record.cobol.CobolType.fromStringInitialValue(this,18, new com.ibm.ivj.eab.record.cobol.CobolInitialValueObject(" ,null"),9,0,1,false,false,false,0,0,"X(1)",false,true);
      com.ibm.ivj.eab.record.cobol.CobolType.fromStringInitialValue(this,19, new com.ibm.ivj.eab.record.cobol.CobolInitialValueObject(" ,null"),9,0,1,false,false,false,0,0,"X(1)",false,true);
      com.ibm.ivj.eab.record.cobol.CobolType.fromStringInitialValue(this,20, new com.ibm.ivj.eab.record.cobol.CobolInitialValueObject(" ,null"),9,0,2,false,false,false,-1,0,"X(2)",false,true);
      com.ibm.ivj.eab.record.cobol.CobolType.fromStringInitialValue(this,22, new com.ibm.ivj.eab.record.cobol.CobolInitialValueObject(" ,null"),9,0,2,false,false,false,-1,0,"X(2)",false,true);
      com.ibm.ivj.eab.record.cobol.CobolType.fromStringInitialValue(this,24, new com.ibm.ivj.eab.record.cobol.CobolInitialValueObject(" ,null"),9,0,6,false,false,false,-5,0,"X(6)",false,true);
      com.ibm.ivj.eab.record.cobol.CobolType.fromStringInitialValue(this,30, new com.ibm.ivj.eab.record.cobol.CobolInitialValueObject(" ,null"),9,0,1,false,false,false,0,0,"X(1)",false,true);
      com.ibm.ivj.eab.record.cobol.CobolType.fromStringInitialValue(this,31, new com.ibm.ivj.eab.record.cobol.CobolInitialValueObject(" ,null"),9,0,250,false,false,false,-249,0,"X(250)",false,true);
      com.ibm.ivj.eab.record.cobol.CobolType.fromStringInitialValue(this,281, new com.ibm.ivj.eab.record.cobol.CobolInitialValueObject(" ,null"),9,0,250,false,false,false,-249,0,"X(250)",false,true);
      com.ibm.ivj.eab.record.cobol.CobolType.fromStringInitialValue(this,531, new com.ibm.ivj.eab.record.cobol.CobolInitialValueObject(" ,null"),9,0,8,false,false,false,-7,0,"X(8)",false,true);
      com.ibm.ivj.eab.record.cobol.CobolType.fromStringInitialValue(this,539, new com.ibm.ivj.eab.record.cobol.CobolInitialValueObject(" ,null"),9,0,26,false,false,false,-25,0,"X(26)",false,true);
      com.ibm.ivj.eab.record.cobol.CobolType.fromStringInitialValue(this,565, new com.ibm.ivj.eab.record.cobol.CobolInitialValueObject(" ,null"),9,0,8590,false,false,false,-8589,0,"X(8590)",false,true);
      return;
   }

   public static Class getMetadataClass() {
      try {
         return Class.forName("com.arkea.com.arkea.commons.archetypes.server.dao.host.tn00pr0.copy.Y00PR0");
      } catch (ClassNotFoundException e) {
         return null;
      }
   }

}
/**
 * This is a generated file.  Do not edit.
 */
