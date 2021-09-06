package sn.gainde2000.orbuslink.visa.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@Entity
@Table(name = "td_utilisateur")
//@NoArgsConstructor
@AllArgsConstructor

public class Utilisateur implements Serializable, UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8027589498244487525L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="utiId")
    private Long id;
	@Column(name="uti_prenom")
    private String prenom;
	@Column(name="uti_nom")
    private String nom;
	@Column(name="uti_telephone")
    private String telephone;
    @Column(name="uti_email", unique = true)
    private String email;
	@Column(name="uti_password")
    //@JsonProperty(access = JsonProperty.Access.AUTO)
    private String password="$2a$10$rt9NYYq4XveHWteKHOOUOetICo5yKrXbJELK/1tM/H6diYxksRmwC";
	@Column(name="uti_statut")
    private boolean statut=true;
	@Column(name="uti_abonnement")
    private boolean abonnement=false;
	@CreationTimestamp
    private LocalDateTime dateAbonnement;
	@Column(name="uti_firstConnection")
    private boolean firstConnection=true;
    @Column(name="uti_matricule", nullable = true)
    private String matricule;
    @Column(name="uti_signatureKeyId")
    private String signatureKeyId;
    @Column(name="uti_delagationId")
    private String delagation;
    
    @Column(name="uti_signatureKeyIdProf")
    private String signatureKeyIdProf;
    @Column(name="uti_delagationIdProf")
    private String delagationProf;
    
    @CreationTimestamp
    private LocalDateTime createDateTime;
    @UpdateTimestamp
    private LocalDateTime updateDateTime;
    @ManyToOne
    @JoinColumn(name="uti_pro_id")
    private Profil profil;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="uti_str_id",nullable = true, updatable = true, insertable = true)
    private Structure structure;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="uti_con_id",nullable = true, updatable = true, insertable = true)
    //@JsonIgnore
    //@JsonIgnoreProperties(value = "utilisateurs", allowSetters = true)
    private Contribuable contribuable; 
    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>() ;
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(this.profil.getNom());
        grantedAuthorities.add(authority) ;
        return grantedAuthorities;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return statut;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public Utilisateur() {
		// TODO Auto-generated constructor stub
	}


}
