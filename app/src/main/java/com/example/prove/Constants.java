package com.example.prove;

public class Constants {

    public static final String MODO_CONSUNTIVO_N = "N";
    //region db column name
    public static final String VALORE_COLUMN = "XFBTACOSVALUE";
    public static final String QUALIFICA_COLUMN = "QUALIFICA";
    public static final String YES = "Y";
    public static final String MATERIALE_GDM = "GDM";
    public static final String TRACCIATURA_COLUMN = "TRACCIATURA";
    public static final String NOTIFICA_DA_DIARIO_COLUMN = "NOTIFICA_DA_DIARIO";
    public static final String MATRICOLA_MATERIALE_COLUMN = "MATRICOLA_MATERIALE";
    public static final String FL_NON_POSABILE_COLUMN = "FL_NON_POSABILE";
    public static final String DESCRIZIONE_COLUMN = "DESCRIZIONE";
    public static final String UNITA_MISURA_COLUMN = "UNITA_MISURA";
    public static final String CIFRE_DECIMALI_COLUMN = "CIFRE_DECIMALI";
    public static final String VALUE_COLUMN = "value";
    public static final String LABEL_COLUMN = "label";
    public static final String OPERAZIONE_COLUMN = "OPERAZIONE";
    public static final String ID_GRUPPO_SAM_COLUMN = "ID_GRUPPO_SAM";
    public static final String POSA_RECUPERO_COLUMN = "POSA_RECUPERO";
    public static final String QTA_MAX_COLUMN = "QTA_MAX";
    public static final String QTA_MIN_COLUMN = "QTA_MIN";
    public static final String RESOLUTION_DIVIDER = "x";
    //endregion

    //region sired
    public static final String NOTIFICA_AUI_COLUMN = "NOTIFICA_AUI";
    public static final String FLAG_PROJECT_SYSTEM_TRUE_NEW = "1";
    //endregion

    // region materials
    public static final String ENABLE_TRACE_MAT = "1";
    public static final String CIT = "cit";
    public static final String UO = "uo";
    public static final String APP = "app";
    public static final String IDWOA = "idWoa";
    public static final String MATERIALI_PREVENTIVATI = "materialiPreventivati";
    public static final String MATERIALI_AUTOMATICI = "materialiAutomatici";
    public static final String WAREHOUSE_PREVENTIVATI = "warehousePreventivati";
    public static final String MATERIALI_UTENTE = "materialiUtente";
    public static final String MATRICOLA_MATERIALE = "matricolaMateriale";
    public static final String QNT_POSATA = "qntPosata";
    public static final String QNT_RECUPERATA = "qntRecuperata";
    public static final String FLAG_PROVENIENZA = "flagProvenienza";
    public static final String TAM = "tam";
    public static final String TISP = "tisp";
    public static final String TIPOLOGIA_OPERATORE = "tipologiaOperatore";
    public static final String GRUPPO_ATTIVITA = "gruppoAttivita";
    public static final String FROM_CIT_CHANGE = "fromCitChange";
    public static final String UPDATE_DECS = "updateDecs";
    public static final String PRIMA_CONSUNTIVAZIONE = "PRIMA_CONSUNTIVAZIONE";
    public static final String DECS_DEFAULT = "decsDefault";
    public static final String DECS = "decs";
    public static final String SEC_CONS = "secCons";
    public static final String TIPO_OGGETTO = "tipoOggetto";
    public static final String MATERIAL_METHOD = "MATERIAL_METHOD";
    public static final String MATERIAL_METHOD_GET_MATERIALS = "getMaterials";
    public static final String MATERIAL_METHOD_UPDATE_MATERIALS = "updateMaterial";
    public static final String CODICE_CABINA = "codiceCabina";
    public static final String MATERIALI = "materiali";
    public static final String CODICE_LINEA = "codiceLinea";
    public static final String BARCODE_MATERIALE_TB_NAME = "BarcodeMateriali";
    public static final String MATERIALE_TB_NAME = "Materiale";
    public static final String MATERIALE_LAVORATO_TB_NAME = "MaterialiLavorati";
    public static final String LANGUAGE_LABEL_TB_NAME = "LanguageLabel";
    public static final String DIARI_INFO_TB_NAME = "DiariInfo";
    public static final String SAM_TB_NAME = "Sam";
    public static final String SAVED_COLUMN = "saved";
    public static final String QNT_POSATA_COLUMN = "qntPosata";
    public static final String QNT_RECUPERATA_COLUMN = "qntRecuperata";
    public static final String MATERIALE_CLASS_USER = "U";
    public static final String MATERIALE_CLASS_AUTOMATICO = "A";
    public static final String MATERIALE_CLASS_PREVENTIVATO = "P";
    public static final String MATERIALE_TAB_PRIORITARIO = "PRIORITARIO";
    public static final String MATERIALE_TAB_ALTRO = "ALTRO";
    public static final String MATERIALE_TAB_CALCOLATO = "CALCOLATO";
    public static final String MATERIALE_TAB_ND = "ND";
    public static final String VALUE_UNO = "1";
    public static final String APP_NAME_FOR_COSTANTI_TB = "DIARIO";
    public static final String COMPATIBILITA_COLUMN = "COMPATIBILITA";
    public static final String ELIMINA_MATERIALI_KEY = "EliminazioneMateriali_IDWOA";
    public static final String DECS_DEFAULT_COLUMN = "decsDefault";
    public static final String DECS_COLUMN = "decs";
    public static final String DT_MOD_DECS_COLUMN = "dtModDecs";
    public static final String TYPE_TO_DOWNLOAD = "TYPE_TO_DOWNLOAD";
    public static final String TYPE_ALL = "TYPE_ALL";
    public static final String TYPE_PRIORITARI = "PRIORITARI";
    public static final String TYPE_ALTRI = "ALTRI";
    public static final String SAM_CODE = "SAM_CODE";
    public static final String AUTOMATICI_MODULO = "automaticiModulo";
    public static final String REGISTERED_VAT_NUMBER = "registeredVatNumber";
    public static final String CONTRACT_CODE = "contractCode";


    public static final String VALUE_0 = "0";
    public static final String VALUE_1 = "1";
    public static final String VALUE_2 = "2";
    public static final String VALUE_3 = "3";
    public static final String VALUE_4 = "4";
    public static final String VALUE_5 = "5";
    public static final String VALUE_6 = "6";

    public static final String SIRED_OK = "OK";
    public static final String SIRED_KO = "KO";
    public static final String SIRED_WARINING = "Warning";
    public static final String SIRED_MAT_NON_GESTITO = "Il materiale non risulta gestito da AUI";
    public static final String SIRED_NO_CONNECTION = "Mancanza di connettività";
    public static final String SIRED_TIMEOUT = "TIMOUT";
    public static final String SIRED_NO_DATI = "SIRED_NO_DATI";
    public static final String ACTION_GET_MATERIALS = "wfm.in.enel.com.smtu.getMaterials";
    public static final String ACTION_MODIFY_MATERIAL = "wfm.in.enel.com.smtu.updateMaterial";
    public static final String ACTION_SCAN_MATERIAL = "wfm.in.enel.com.smtu.scanMaterial";
    public static final String ACTION_BARCODE_SCANNER = "wfm.in.enel.com.smtu.barcodeScanner";
    public static final String ACTION_INFOCAM = "wfm.in.enel.com.smtu.infocam";
    public static final String ACTION_ADD_ATTACHMENTS = "wfm.in.enel.com.smtu.addAttachments";
    public static final String FALSE = "false";


    //region materiali column
    public static final String MATRICOLA_MATERIALE_SMTU_COLUMN = "matricolaMateriale";
    public static final String TAB_MATERIALE_COLUMN = "tabMateriale";
    public static final String DESCRIZIONE_SMTU_COLUMN = "descrizione";
    public static final String BARCODE_COLUMN = "barcode";
    public static final String UNITA_MISURA_SMTU_COLUMN = "unitaMisura";
    public static final String FLAG_PROVENIENZA_COLUMN = "flagProvenienza";
    public static final String CIFRE_DECIMALI_SMTU_COLUMN = "cifreDecimali";
    public static final String CHECKED_COLUMN = "checked";
    public static final String FROM_MODULO_COLUMN = "fromModulo";
    public static final String FLAG_POSABILE_COLUMN = "flagPosabile";
    public static final String FLAG_TRACCIATURA_COLUMN = "flagTracciatura";
    public static final String FLAG_SIRED_COLUMN = "flagSired";
    public static final String TIME_TO_LIVE_COLUMN = "timeToLive";
    public static final String CURRENT_WORK_COLUMN = "currentWork";
    public static final String ID_SAM_COLUMN = "idGruppoSam";
    public static final String DECS_SAM_COLUMN = "descrizioneGruppo";
    public static final String FLAG_POSA_RECUPERO_COLUMN = "flagPosaRecupero";
    public static final String QNT_MIN_P_COLUMN = "qntMinP";
    public static final String QNT_MAX_P_COLUMN = "qntMaxP";
    public static final String QNT_MIN_R_COLUMN = "qntMinR";
    public static final String QNT_MAX_R_COLUMN = "qntMaxR";
    public static final String GRUPPO_SAM_COLUMN = "gruppoSam";
    public static final String FLAG_RECUPERATA = "R";
    public static final String FLAG_POSATA = "P";
    public static final String DT_MOD_DECS_DF = "dd/MM/yyyy HH:mm:ss";

    //endregion

    //region formatted strings
    public static final String COMPLETE_DATE = "EEE MMM dd HH:mm:ss ZZZZ yyyy";
    //endregion

    //region authorizations and user
    public static final String CL_TERZI = "CL_TERZI";
    public static final String CL_FORMAZIONE = "CL_FORMAZIONE";
    public static final String SIRED_ENABLED = "SP_AUIMOB_MONOP";
    public static final String TIPO_ESECUTORE_IMPRESA = "I";
    public static final String TIPO_ESECUTORE_ENEL = "E";
    //endregion

    public static final int FIRST = 0;
    public static final int LAST = 1;

    public static final int FOUND_WORK_DIFFERENT_CIT = 3;
    public static final int FOUND_NOT_CURRENT_WORK = 2;
    public static final int FOUND_AND_CURRENT_WORK = 1;
    public static final int FOUND_AND_CURRENT_WORK_CHANGE_MODULE = 4;
    public static final int NOT_FOUND_WORK = 0;

    public static final int SMTU_DB_VERSION_1 = 1;
    public static final int SMTU_DB_VERSION_2 = 2;
    public static final int SMTU_DB_VERSION_3 = 3;
    public static final int SMTU_DB_VERSION_4 = 4;
    public static final int SMTU_DB_VERSION_5 = 5;
    public static final int SMTU_DB_VERSION_6 = 6;
    public static final int SMTU_DB_VERSION_7 = 7;
    public static final int SMTU_DB_VERSION_8 = 8;
    public static final int SMTU_DB_VERSION_9 = 9;
    public static final int SMTU_DB_VERSION_10 = 10;

    //region constants ex MainActicity

    public static final String CONTENT_URI = "content://";
    public static final String SMTU_PACKAGE = "wfm.in.enel.com.smtu";
    public static final String SMDP_PACKAGE = "wfm.in.enel.com.dpf";
    public static final String NETNAV_PACKAGE = "com.arcoda.netnav";
    public static final String NETNAV_ACTION = "GUI_REQUEST";
    public static final String SMPR_ACTION = "wfm.in.enel.com.dpr.COMMAND";
    public static final String SEND_DATA_TO = "wfm.in.enel.com.legoenel.RECEIVE_DATA";
    public static final String INPUT_INTENT_ACTION = SMTU_PACKAGE + ".FB_START_OPERATION";
    public static final String INPUT_WOL_INTENT_ACTION = SMTU_PACKAGE + ".FB_WOL_START_OPERATION";
    public static final String SMTU_MAIN_ACTIVITY = SMTU_PACKAGE + ".MainActivity";
    public static final String MT_PACKAGE_NAME = "MT_PACKAGE_NAME";
    public static final String MT_PACKAGE_VERSION = "MT_PACKAGE_VERSION";
    public static final String WS_OPERATION_TYPE = "WS_OPERATION_TYPE";
    public static final String MT_OPERATION_ID = "MT_OPERATION_ID";
    public static final String MT_BUNDLE_DATA_TYPE = "MT_BUNDLE_DATA_TYPE";
    public static final String MT_RESULT_BROADCAST_ACTION = "MT_RESULT_BROADCAST_ACTION";
    public static final String WS_WB = "WS_WB";
    public static final String WS_EXT = "WS_EXT";
    public static final String WS_DATA = "WS_DATA";
    public static final String PAYLOAD_EXPRESSION = "/WORK_SET/PAYLOAD";
    public static final String SMTU_USER_AUTHORIZATION = "CL_Richiesta_Rdl";

    public static final String DB_SMDP = "geocall_dbstato";
    public static final String TABLE_SMDP = "XFBTTFIELDACTIVITYMATRIX";

    public static final String MOBAUTH_CHANNEL_NAME = "smtu.integrations.mobauth";
    public static final String MODULES_CHANNEL_NAME = "smtu.integrations.modules";
    public static final String TIPO_ESECUTORE_TERZI = "T";

    //fake app region
    public static final String PHOTO_VIDEO_LABEL = "PHOTO_VIDEO_ACTION";
    public static final String VIDEO_ACTION = "video";
    public static final String PICTURE_ACTION = "picture";
    //endregion
    public static final String MODE_ADD_ATTACHMENTS = "attachments";

    public static final String SMTU_MAIN_ACTIVITY_CAMERA = SMTU_PACKAGE + ".MainActivityCamera";

    public static final String SWIM_SEND_SMDP = "SWIM_SEND_SMDP";
    public static final String SWIM_CLASS = "SWIM_CLASS";
    public static final String SWIM_ATTACHMENT_TO_FB = "SWIM_ATTACHMENT_TO_FB";


}
