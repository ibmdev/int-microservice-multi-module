package fr.sma.bw.entities;

import java.io.Serializable;
import java.util.Date;

public class JournalTechnique implements Serializable {

    public JournalTechnique() {}
    private Integer idOperation;
    private String lbOperation;
    private String typeOperation;
    private String dateOperation;
    private String idCorrelation;
    private Date dateRetourOperation;
    private int statut;
    private String idDemande;
    private String cdRetour;
    private String lbRetour;
    private byte[] fluxEntree;
    private String cdApplication;
    private byte[] fluxRetour;

    public Integer getIdOperation() {
        return idOperation;
    }

    public void setIdOperation(Integer idOperation) {
        this.idOperation = idOperation;
    }

    public String getLbOperation() {
        return lbOperation;
    }

    public void setLbOperation(String lbOperation) {
        this.lbOperation = lbOperation;
    }

    public String getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(String typeOperation) {
        this.typeOperation = typeOperation;
    }

    public String getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(String dateOperation) {
        this.dateOperation = dateOperation;
    }

    public String getIdCorrelation() {
        return idCorrelation;
    }

    public void setIdCorrelation(String idCorrelation) {
        this.idCorrelation = idCorrelation;
    }

    public Date getDateRetourOperation() {
        return dateRetourOperation;
    }

    public void setDateRetourOperation(Date dateRetourOperation) {
        this.dateRetourOperation = dateRetourOperation;
    }

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    public String getIdDemande() {
        return idDemande;
    }

    public void setIdDemande(String idDemande) {
        this.idDemande = idDemande;
    }

    public String getCdRetour() {
        return cdRetour;
    }

    public void setCdRetour(String cdRetour) {
        this.cdRetour = cdRetour;
    }

    public String getLbRetour() {
        return lbRetour;
    }

    public void setLbRetour(String lbRetour) {
        this.lbRetour = lbRetour;
    }

    public byte[] getFluxEntree() {
        return fluxEntree;
    }

    public void setFluxEntree(byte[] fluxEntree) {
        this.fluxEntree = fluxEntree;
    }

    public String getCdApplication() {
        return cdApplication;
    }

    public void setCdApplication(String cdApplication) {
        this.cdApplication = cdApplication;
    }

    public byte[] getFluxRetour() {
        return fluxRetour;
    }

    public void setFluxRetour(byte[] fluxRetour) {
        this.fluxRetour = fluxRetour;
    }
}
