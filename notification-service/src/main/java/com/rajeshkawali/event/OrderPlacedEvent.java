package com.rajeshkawali.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author Rajesh_Kawali
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderPlacedEvent {
    private String orderNumber;
}