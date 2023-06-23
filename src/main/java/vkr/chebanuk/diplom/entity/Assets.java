package vkr.chebanuk.diplom.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.ByteArrayInputStream;
import java.sql.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Assets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String inventoryNumber;
    private String model;
    private String factoryNumber;
    private String auditorium;
    private String note;
    private byte[] QRcode;
    private String photo;
    private Double cost;
    private Double balanceCost;
    private Double quantity;
    private String type;
    private String category;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date commissioningDate;
}
