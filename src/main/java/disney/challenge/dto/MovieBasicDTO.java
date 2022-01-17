/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disney.challenge.dto;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MovieBasicDTO {
    
    private String id;
    
    private String image;
    
    private String title;
    
    private String creationDate;

    
}
