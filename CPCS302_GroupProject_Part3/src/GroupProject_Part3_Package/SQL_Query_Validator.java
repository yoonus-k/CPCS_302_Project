/* SQL_Query_Validator.java */
/* Generated By:JavaCC: Do not edit this line. SQL_Query_Validator.java */
package GroupProject_Part3_Package;

public class SQL_Query_Validator implements SQL_Query_ValidatorConstants {
  public static void main(String args []) throws ParseException
  {
    SQL_Query_Validator parser = new SQL_Query_Validator(System.in);

        System.out.println("Enter any query:");
        try {
            parser.query();
            System.out.println("Valid SQL Query");
        } catch (ParseException e) {
            System.out.println("Invalid SQL Query: " + e.getMessage());
        }
  }

  static final public void query() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case SELECT:
    case INSERT:
    case UPDATE:
    case DELETE:{
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case SELECT:{
        selectQuery();
        break;
        }
      case INSERT:{
        insertQuery();
        break;
        }
      case UPDATE:{
        updateQuery();
        break;
        }
      case DELETE:{
        deleteQuery();
        break;
        }
      default:
        jj_la1[0] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
      }
    default:
      jj_la1[1] = jj_gen;
      ;
    }
    jj_consume_token(20);
}

  static final public void selectQuery() throws ParseException {
    jj_consume_token(SELECT);
    columnList();
    jj_consume_token(FROM);
    jj_consume_token(IDENTIFIER);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case WHERE:{
      jj_consume_token(WHERE);
      condition();
      break;
      }
    default:
      jj_la1[2] = jj_gen;
      ;
    }
}

  static final public void insertQuery() throws ParseException {
    jj_consume_token(INSERT);
    jj_consume_token(INTO);
    jj_consume_token(IDENTIFIER);
    jj_consume_token(LPARENTHESIS);
    columnList();
    jj_consume_token(RPARENTHESIS);
    jj_consume_token(VALUES);
    jj_consume_token(LPARENTHESIS);
    valueList();
    jj_consume_token(RPARENTHESIS);
}

  static final public void updateQuery() throws ParseException {
    jj_consume_token(UPDATE);
    jj_consume_token(IDENTIFIER);
    jj_consume_token(SET);
    assignmentList();
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case WHERE:{
      jj_consume_token(WHERE);
      condition();
      break;
      }
    default:
      jj_la1[3] = jj_gen;
      ;
    }
}

  static final public void deleteQuery() throws ParseException {
    jj_consume_token(DELETE);
    jj_consume_token(FROM);
    jj_consume_token(IDENTIFIER);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case WHERE:{
      jj_consume_token(WHERE);
      condition();
      break;
      }
    default:
      jj_la1[4] = jj_gen;
      ;
    }
}

  static final public void columnList() throws ParseException {
    jj_consume_token(IDENTIFIER);
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case COMMA:{
        ;
        break;
        }
      default:
        jj_la1[5] = jj_gen;
        break label_1;
      }
      jj_consume_token(COMMA);
      jj_consume_token(IDENTIFIER);
    }
}

  static final public void valueList() throws ParseException {
    jj_consume_token(VALUE);
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case COMMA:{
        ;
        break;
        }
      default:
        jj_la1[6] = jj_gen;
        break label_2;
      }
      jj_consume_token(COMMA);
      jj_consume_token(VALUE);
    }
}

  static final public void assignmentList() throws ParseException {
    jj_consume_token(IDENTIFIER);
    jj_consume_token(EQUAL);
    jj_consume_token(VALUE);
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case COMMA:{
        ;
        break;
        }
      default:
        jj_la1[7] = jj_gen;
        break label_3;
      }
      jj_consume_token(COMMA);
      jj_consume_token(IDENTIFIER);
      jj_consume_token(EQUAL);
      jj_consume_token(VALUE);
    }
}

  static final public void condition() throws ParseException {
    jj_consume_token(IDENTIFIER);
    jj_consume_token(EQUAL);
    jj_consume_token(VALUE);
}

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public SQL_Query_ValidatorTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[8];
  static private int[] jj_la1_0;
  static {
	   jj_la1_init_0();
	}
	private static void jj_la1_init_0() {
	   jj_la1_0 = new int[] {0x2920,0x2920,0x80,0x80,0x80,0x4000,0x4000,0x4000,};
	}

  /** Constructor with InputStream. */
  public SQL_Query_Validator(java.io.InputStream stream) {
	  this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public SQL_Query_Validator(java.io.InputStream stream, String encoding) {
	 if (jj_initialized_once) {
	   System.out.println("ERROR: Second call to constructor of static parser.  ");
	   System.out.println("	   You must either use ReInit() or set the JavaCC option STATIC to false");
	   System.out.println("	   during parser generation.");
	   throw new Error();
	 }
	 jj_initialized_once = true;
	 try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
	 token_source = new SQL_Query_ValidatorTokenManager(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 8; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
	  ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
	 try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
	 token_source.ReInit(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 8; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public SQL_Query_Validator(java.io.Reader stream) {
	 if (jj_initialized_once) {
	   System.out.println("ERROR: Second call to constructor of static parser. ");
	   System.out.println("	   You must either use ReInit() or set the JavaCC option STATIC to false");
	   System.out.println("	   during parser generation.");
	   throw new Error();
	 }
	 jj_initialized_once = true;
	 jj_input_stream = new SimpleCharStream(stream, 1, 1);
	 token_source = new SQL_Query_ValidatorTokenManager(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 8; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
	if (jj_input_stream == null) {
	   jj_input_stream = new SimpleCharStream(stream, 1, 1);
	} else {
	   jj_input_stream.ReInit(stream, 1, 1);
	}
	if (token_source == null) {
 token_source = new SQL_Query_ValidatorTokenManager(jj_input_stream);
	}

	 token_source.ReInit(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 8; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public SQL_Query_Validator(SQL_Query_ValidatorTokenManager tm) {
	 if (jj_initialized_once) {
	   System.out.println("ERROR: Second call to constructor of static parser. ");
	   System.out.println("	   You must either use ReInit() or set the JavaCC option STATIC to false");
	   System.out.println("	   during parser generation.");
	   throw new Error();
	 }
	 jj_initialized_once = true;
	 token_source = tm;
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 8; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(SQL_Query_ValidatorTokenManager tm) {
	 token_source = tm;
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 8; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
	 Token oldToken;
	 if ((oldToken = token).next != null) token = token.next;
	 else token = token.next = token_source.getNextToken();
	 jj_ntk = -1;
	 if (token.kind == kind) {
	   jj_gen++;
	   return token;
	 }
	 token = oldToken;
	 jj_kind = kind;
	 throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
	 if (token.next != null) token = token.next;
	 else token = token.next = token_source.getNextToken();
	 jj_ntk = -1;
	 jj_gen++;
	 return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
	 Token t = token;
	 for (int i = 0; i < index; i++) {
	   if (t.next != null) t = t.next;
	   else t = t.next = token_source.getNextToken();
	 }
	 return t;
  }

  static private int jj_ntk_f() {
	 if ((jj_nt=token.next) == null)
	   return (jj_ntk = (token.next=token_source.getNextToken()).kind);
	 else
	   return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
	 jj_expentries.clear();
	 boolean[] la1tokens = new boolean[21];
	 if (jj_kind >= 0) {
	   la1tokens[jj_kind] = true;
	   jj_kind = -1;
	 }
	 for (int i = 0; i < 8; i++) {
	   if (jj_la1[i] == jj_gen) {
		 for (int j = 0; j < 32; j++) {
		   if ((jj_la1_0[i] & (1<<j)) != 0) {
			 la1tokens[j] = true;
		   }
		 }
	   }
	 }
	 for (int i = 0; i < 21; i++) {
	   if (la1tokens[i]) {
		 jj_expentry = new int[1];
		 jj_expentry[0] = i;
		 jj_expentries.add(jj_expentry);
	   }
	 }
	 int[][] exptokseq = new int[jj_expentries.size()][];
	 for (int i = 0; i < jj_expentries.size(); i++) {
	   exptokseq[i] = jj_expentries.get(i);
	 }
	 return new ParseException(token, exptokseq, tokenImage);
  }

  static private boolean trace_enabled;

/** Trace enabled. */
  static final public boolean trace_enabled() {
	 return trace_enabled;
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}
