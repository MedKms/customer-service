package expleo.ma.customerservice.service;

import expleo.ma.customerservice.dto.CustomerRequestDTO;
import expleo.ma.customerservice.dto.CustomerResponseDTO;

import java.util.List;

public interface CustomerService {
    CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO);
    CustomerResponseDTO getCustomer(String id);
    CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO);
    void delete(String idCustomer);
    List<CustomerResponseDTO> listCustomers();

}
