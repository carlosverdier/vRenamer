package vrenamer;

/**
 *
 * @author carlos
 */
public class vDatos {
    
  private String grupoRenombra, texInserta, spInserta, spDesde, spHasta, reemUno, reemDos, aleaSel, spAleatorio, txtFiltro, txtExt, txtSepara, txtSym, normalizaTri, normaPos, normaCer, numerosE, numerosSal, numerosPos;
  private int Contador, modoReem, opCapi, opNorma, opNume, opAtri, opAtriEst, tabPanel, opSepara, cAtrib;
  private int[] estadoContador, secuenciaTip, secuenciaTipoCas, numeraCeros, opcionNumeracion, comArchivos, comFinal, comCarpeta, comSepFecha, comFecha, comFechaMeta, comCamara, comMusica, selecCampos, iAtrib;
  private String[] txtTexto, numeraEmpieza, numeraSalto, txtCorte, archDesde, archHasta, archTextoDesde, archTextoHasta, spSeccion, txtCampos;
  private Boolean derInserta, derTrimInserta, derElimina, ckExtension, ckSepara, Case, Excluye, checkNum, checkNorma, checkReem, checkAtri, checkAlea, checkMay;
  private boolean[] esSeleccionado, esActivo;
  public String getGrupoRenombra() {
    return grupoRenombra;
  }
  public int getContador() {
    return Contador;
  }
  public int[] getEstadoContador() {
    return estadoContador;
  }
  public int[] getSelecCampos() {
    return selecCampos;
  }
  public boolean[] getEsSeleccionado() {
      return esSeleccionado;
  }
  public boolean[] getEsActivo() {
      return esActivo;
  }  
  public String[] getTxtCampos() {
    return txtCampos;
  }
  public String[] getTxtTexto() {
    return txtTexto;
  }
  public int[] getSecuenciaTipo() {
    return secuenciaTip;
  }
  public int[] getSecuenciaTipoCase() {
    return secuenciaTipoCas;
  }
  public int[] getNumeraCeros() {
    return numeraCeros;
  }
  public int[] getOpcionNumeracion() {
    return opcionNumeracion;
  }
  public String[] getNumeraEmpieza() {
    return numeraEmpieza;
  }
  public String[] getNumeraSalto() {
    return numeraSalto;
  }
  public int[] getComArchivos() {
    return comArchivos;
  }
  public String[] getTxtCorte() {
    return txtCorte;
  }
  public String[] getSpSeccion() {
    return spSeccion;
  }
  public int[] getComFinal() {
    return comFinal;
  }
  public String[] getArchDesde() {
    return archDesde;
  }
  public String[] getArchHasta() {
    return archHasta;
  }
  public String[] getArchTextoDesde() {
    return archTextoDesde;
  }
  public String[] getArchTextoHasta() {
    return archTextoHasta;
  }
  public int[] getComCarpeta() {
    return comCarpeta;
  }
  public int[] getComSepFecha() {
    return comSepFecha;
  }
  public int[] getComFecha() {
    return comFecha;
  }
  public int[] getComFechaMeta() {
    return comFechaMeta;
  }
  public int[] getComCamara() {
    return comCamara;
  }
  public int[] getComMusica() {
    return comMusica;
  }
  public String getTexInserta() {
    return texInserta;
  }
  public String getSpInserta() {
    return spInserta;
  }
  public Boolean getDerInserta() {
    return derInserta;
  }
  public Boolean getDerTrimInserta() {
    return derTrimInserta;
  }
  public String getSpDesde() {
    return spDesde;
  }
  public String getSpHasta() {
    return spHasta;
  }
  public Boolean getDerElimina() {
    return derElimina;
  }
  public String getReemUno() {
    return reemUno;
  }
  public String getReemDos() {
    return reemDos;
  }
  public int getModoReem() {
    return modoReem;
  }
  public String getAleaSel() {
    return aleaSel;
  }
  public String getSpAleatorio() {
    return spAleatorio;
  }
  public int getOpCapi() {
    return opCapi;
  }
  public int getOpNorma() {
    return opNorma;
  }
  public int getOpNumeros() {
    return opNume;
  }
  public int getOpAtri() {
    return opAtri;
  }
  public int[] getIAtrib() {
    return iAtrib;
  }
  public int getCAtrib() {
    return cAtrib;
  }
  public int getOpAtriEst() {
    return opAtriEst;
  }

  public String getTxtSym() {
    return txtSym;
  }
  public String getNormalizaTrim() {
    return normalizaTri;
  }
  public String getNormaPosicion() {
    return normaPos;
  }
  public String getNormaCeros() {
    return normaCer;
  }
  public String getNumerosEn() {
    return numerosE;
  }
  public String getNumerosSalto() {
    return numerosSal;
  }
  public String getNumerosPosicion() {
    return numerosPos;
  }
  public Boolean getCheckNum() {
    return checkNum;
  }
  public Boolean getCheckNorma() {
    return checkNorma;
  }
  public Boolean getCheckReem() {
    return checkReem;
  }
  public Boolean getCheckAtri() {
    return checkAtri;
  }
  public Boolean getCheckAlea() {
    return checkAlea;
  }
  public Boolean getCheckMay() {
    return checkMay;
  }

  public int getTabPanel() {
    return tabPanel;
  }
  public String getTxtFiltro() {
    return txtFiltro;
  }
  public Boolean getCase() {
    return Case;
  }
  public Boolean getExcluye() {
    return Excluye;
  }
  public Boolean getCkExtension() {
    return ckExtension;
  }
  public String getTxtExt() {
    return txtExt;
  }
  public Boolean getCkSepara() {
    return ckSepara;
  }
  public String getTxtSepara() {
    return txtSepara;
  }
  public int getOpSepara() {
    return opSepara;
  }

  public void setGrupoRenombra(String grupoRenombra) {
    this.grupoRenombra = grupoRenombra;
  }
  public void setContador(int Contador) {
    this.Contador = Contador;
  }
  public void setEstadoContador(int[] estadoContador) {
    this.estadoContador = estadoContador;
  }
  public void setSelecCampos(int[] selecCampos) {
    this.selecCampos = selecCampos;
  }
  public void setEsSeleccionado(boolean[] esSeleccionado) {
      this.esSeleccionado = esSeleccionado;
  }
  public void setEsActivo(boolean[] esActivo) {
      this.esActivo = esActivo;
  }  
  public void setTxtCampos(String[] txtCampos) {
    this.txtCampos = txtCampos;
  }
  public void setTxtTexto(String[] txtTexto) {
    this.txtTexto = txtTexto;
  }
  public void setSecuenciaTipo(int[] secuenciaTip) {
    this.secuenciaTip = secuenciaTip;
  }  
  public void setSecuenciaTipoCase(int[] secuenciaTipoCas) {
    this.secuenciaTipoCas = secuenciaTipoCas;
  }  

  public void setNumeraCeros(int[] numeraCeros) {
    this.numeraCeros = numeraCeros;
  }
  public void setOpcionNumeracion(int[] opcionNumeracion) {
    this.opcionNumeracion = opcionNumeracion;
  }
  public void setNumeraEmpieza(String[] numeraEmpieza) {
    this.numeraEmpieza = numeraEmpieza;
  }
  public void setNumeraSalto(String[] numeraSalto) {
    this.numeraSalto = numeraSalto;
  }
  public void setComArchivos(int[] comArchivos) {
    this.comArchivos = comArchivos;
  }
  public void setTxtCorte(String[] txtCorte) {
    this.txtCorte = txtCorte;
  }
  public void setSpSeccion(String[] spSeccion) {
    this.spSeccion = spSeccion;
  }
  public void setComFinal(int[] comFinal) {
    this.comFinal = comFinal;
  }
  public void setArchDesde(String[] archDesde) {
    this.archDesde = archDesde;
  }
  public void setArchHasta(String[] archHasta) {
    this.archHasta = archHasta;
  }
  public void setArchTextoDesde(String[] archTextoDesde) {
    this.archTextoDesde = archTextoDesde;
  }
  public void setArchTextoHasta(String[] archTextoHasta) {
    this.archTextoHasta = archTextoHasta;
  }
  public void setComCarpeta(int[] comCarpeta) {
    this.comCarpeta = comCarpeta;
  }
  public void setComSepFecha(int[] comSepFecha) {
    this.comSepFecha = comSepFecha;
  }
  public void setComFecha(int[] comFecha) {
    this.comFecha = comFecha;
  }
  public void setComFechaMeta(int[] comFechaMeta) {
    this.comFechaMeta = comFechaMeta;
  }
  public void setComCamara(int[] comCamara) {
    this.comCamara = comCamara;
  }
  public void setComMusica(int[] comMusica) {
    this.comMusica = comMusica;
  }
  public void setTexInserta(String texInserta) {
    this.texInserta = texInserta;
  }
  public void setSpInserta(String spInserta) {
    this.spInserta = spInserta;
  }
  public void setDerInserta(Boolean derInserta) {
    this.derInserta = derInserta;
  }
  public void setDerTrimInserta(Boolean derTrimInserta) {
    this.derTrimInserta = derTrimInserta;
  }
  public void setSpDesde(String spDesde) {
    this.spDesde = spDesde;
  }
  public void setSpHasta(String spHasta) {
    this.spHasta = spHasta;
  }
  public void setDerElimina(Boolean derElimina) {
    this.derElimina = derElimina;
  }
  public void setReemUno(String reemUno) {
    this.reemUno = reemUno;
  }
  public void setReemDos(String reemDos) {
    this.reemDos = reemDos;
  }
  public void setModoReem(int modoReem) {
    this.modoReem = modoReem;
  }
  public void setAleaSel(String aleaSel) {
    this.aleaSel = aleaSel;
  }
  public void setSpAleatorio(String spAleatorio) {
    this.spAleatorio = spAleatorio;
  }
  public void setOpCapi(int opCapi) {
    this.opCapi = opCapi;
  }
  public void setOpNorma(int opNorma) {
    this.opNorma = opNorma;
  }
  public void setOpNumeros(int opNume) {
    this.opNume = opNume;
  }
  public void setOpAtri(int opAtri) {
    this.opAtri = opAtri;
  }
  public void setIAtrib(int[] iAtrib) {
    this.iAtrib = iAtrib;
  }
  public void setCAtrib(int cAtrib) {
    this.cAtrib = cAtrib;
  }
  public void setOpAtriEst(int opAtriEst) {
    this.opAtriEst = opAtriEst;
  }

  public void setTxtSym(String txtSym) {
    this.txtSym = txtSym;
  }
  public void setNormalizaTrim(String normalizaTri) {
    this.normalizaTri = normalizaTri;
  }
  public void setNormaPosicion(String normaPos) {
    this.normaPos = normaPos;
  }
  public void setNormaCeros(String normaCer) {
    this.normaCer = normaCer;
  }
  public void setNumerosEn(String numerosE) {
    this.numerosE = numerosE;
  }
  public void setNumerosSalto(String numerosSal) {
    this.numerosSal = numerosSal;
  }
  public void setNumerosPosicion(String numerosPos) {
    this.numerosPos = numerosPos;
  }

  public void setCheckNum(Boolean checkNum) {
    this.checkNum = checkNum;
  }
  public void setCheckNorma(Boolean checkNorma) {
    this.checkNorma = checkNorma;
  }
  public void setCheckReem(Boolean checkReem) {
    this.checkReem = checkReem;
  }
  public void setCheckAtri(Boolean checkAtri) {
    this.checkAtri = checkAtri;
  }
  public void setCheckAlea(Boolean checkAlea) {
    this.checkAlea = checkAlea;
  }
  public void setCheckMay(Boolean checkMay) {
    this.checkMay = checkMay;
  }

  public void setTabPanel(int tabPanel) {
    this.tabPanel = tabPanel;
  }
  public void setTxtFiltro(String txtFiltro) {
    this.txtFiltro = txtFiltro;
  }
  public void setCase(Boolean Case) {
    this.Case = Case;
  }
  public void setExcluye(Boolean Excluye) {
    this.Excluye = Excluye;
  }
  public void setCkExtension(Boolean ckExtension) {
    this.ckExtension = ckExtension;
  }
  public void setTxtExt(String txtExt) {
    this.txtExt = txtExt;
  }
  public void setCkSepara(Boolean ckSepara) {
    this.ckSepara = ckSepara;
  }
  public void setTxtSepara(String txtSepara) {
    this.txtSepara = txtSepara;
  }
  public void setOpSepara(int opSepara) {
    this.opSepara = opSepara;
  }

}