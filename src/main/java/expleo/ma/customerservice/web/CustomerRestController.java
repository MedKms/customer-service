package expleo.ma.customerservice.web;

import expleo.ma.customerservice.dto.CustomerRequestDTO;
import expleo.ma.customerservice.dto.CustomerResponseDTO;
import expleo.ma.customerservice.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class CustomerRestController {

    private CustomerService customerService;

    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(path = "/customers")
    public List<CustomerResponseDTO> allCustomers(){
        return customerService.listCustomers();
    }
    @PostMapping(path = "/customers")
    public CustomerResponseDTO save(@RequestBody CustomerRequestDTO customerRequestDTO){
        customerRequestDTO.setId(UUID.randomUUID().toString());
        return customerService.save(customerRequestDTO);
    }
    @GetMapping(path = "/customers/{idCustomer}")
    public CustomerResponseDTO getCusomer(@PathVariable String idCustomer){
        return customerService.getCustomer(idCustomer);
    }

    @DeleteMapping(path = "/deleteCustomer/{idCustomer}")
    public void deleteCustomer(@PathVariable String idCustomer){
        customerService.delete(idCustomer);
    }
}
