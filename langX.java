/* langX.java */
/* Generated By:JavaCC: Do not edit this line. langX.java */
package parser;

import java.io.*;


public class langX implements langXConstants {
final static String Version = "X++ Compiler - Version 1.0 - 2004";
boolean Menosshort = false; // saída resumida = falso


// Define o método "main" da classe langX.  
  public  static void main(String args[]) throws ParseException
  {
    String filename = ""; // nome do arquivo a ser analisado
    langX parser;     // analisador léxico/sintático
    int i;
    boolean ms = false;

    System.out.println(Version);
    // lê os parâmetros passados para o compilador
    for (i = 0; i < args.length - 1; i++)
    {
    if ( args[i].toLowerCase().equals("-short") )
      ms = true;
    else
        {
           System.out.println("Usage is: java langX [-short] inputfile");
           System.exit(0);
        }
    }

    if (args[i].equals("-"))
    {       // lê da entrada padrão      
        System.out.println("Reading from standard input . . .");
        parser = new langX(System.in);
     }
     else
    {       // lê do arquivo
        filename = args[args.length-1];
        System.out.println("Reading from file " + filename + " . . .");
        try {
            parser = new langX(new java.io.FileInputStream(filename));
        }
    catch (java.io.FileNotFoundException e) {
               System.out.println("File " + filename + " not found.");
        return;
        }
    }
    parser.Menosshort = ms;
    parser.program();   // chama o método que faz a análise
    if ( parser.token_source.foundLexError() != 0 ) // verifica se houve erro léxico
        System.out.println(parser.token_source.foundLexError() + " Lexical Errors found");
    else
        System.out.println("Program successfully analyzed.");
}  // main

static public String im(int x)
{
int k;
String s;
   s = tokenImage[x];
   k = s.lastIndexOf("\u005c"");
   try {s = s.substring(1,k);}
   catch (StringIndexOutOfBoundsException e)
   {}
   return s;
}

  void program() throws ParseException {Token t;
    do
    {
    t = getNextToken();
    Token st = t;
        while ( st.specialToken != null)
        st = st.specialToken;
        do {
           if ( Menosshort )
          System.out.println(st.image + "  " +
                                 im(st.kind) + " " +
                                 st.kind);
           else
              System.out.println("Line: " + st.beginLine +
                                 " Column: " + st.beginColumn +
                                 " " + st.image +
                                 "  " + im(st.kind) + "  "+t.kind);
          st = st.next;
        } while (st != t.next);
    } while (t.kind != langXConstants.EOF);
  }

  /** Generated Token Manager. */
  public langXTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[0];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {};
   }

  /** Constructor with InputStream. */
  public langX(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public langX(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new langXTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 0; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public langX(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new langXTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
  }

  /** Constructor with generated Token Manager. */
  public langX(langXTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
  }

  /** Reinitialise. */
  public void ReInit(langXTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
  }

  private Token jj_consume_token(int kind) throws ParseException {
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
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk_f() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[63];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 0; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 63; i++) {
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

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

}  // langX

