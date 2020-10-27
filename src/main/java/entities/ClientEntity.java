package entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "client", schema = "public", catalog = "d3aoi5pdhq46hl")
public class ClientEntity {
    private int idclient;
    private String nom;
    private String prenom;
    private Integer cp;
    private String localite;
    private String rue;
    private String num;
    private String tel;
    private Collection<ComfactEntity> comfactsByIdclient;

    @Id
    @Column(name = "idclient", nullable = false)
    public int getIdclient() {
        return idclient;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    @Basic
    @Column(name = "nom", nullable = false, length = 30)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "prenom", nullable = false, length = 20)
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Basic
    @Column(name = "cp", nullable = true)
    public Integer getCp() {
        return cp;
    }

    public void setCp(Integer cp) {
        this.cp = cp;
    }

    @Basic
    @Column(name = "localite", nullable = true, length = 50)
    public String getLocalite() {
        return localite;
    }

    public void setLocalite(String localite) {
        this.localite = localite;
    }

    @Basic
    @Column(name = "rue", nullable = true, length = 30)
    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    @Basic
    @Column(name = "num", nullable = true, length = 10)
    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    @Basic
    @Column(name = "tel", nullable = false, length = 20)
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientEntity that = (ClientEntity) o;

        if (idclient != that.idclient) return false;
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
        if (prenom != null ? !prenom.equals(that.prenom) : that.prenom != null) return false;
        if (cp != null ? !cp.equals(that.cp) : that.cp != null) return false;
        if (localite != null ? !localite.equals(that.localite) : that.localite != null) return false;
        if (rue != null ? !rue.equals(that.rue) : that.rue != null) return false;
        if (num != null ? !num.equals(that.num) : that.num != null) return false;
        if (tel != null ? !tel.equals(that.tel) : that.tel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idclient;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (cp != null ? cp.hashCode() : 0);
        result = 31 * result + (localite != null ? localite.hashCode() : 0);
        result = 31 * result + (rue != null ? rue.hashCode() : 0);
        result = 31 * result + (num != null ? num.hashCode() : 0);
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "clientByFkclient")
    public Collection<ComfactEntity> getComfactsByIdclient() {
        return comfactsByIdclient;
    }

    public void setComfactsByIdclient(Collection<ComfactEntity> comfactsByIdclient) {
        this.comfactsByIdclient = comfactsByIdclient;
    }
}

