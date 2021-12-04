package br.com.bsi.pi.ticketsbsi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.bsi.pi.ticketsbsi.entities.Order;
import br.com.bsi.pi.ticketsbsi.entities.dto.DashboardAddressDTO;
import br.com.bsi.pi.ticketsbsi.entities.dto.DashboardDTO;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(nativeQuery = true, value = "SELECT PRODUCT_ID as productId, P.ADDRESS AS address, P.date_show AS dateShow, sum(O.QUANTITY) as totalTickets, SUM(O.TOTAL) as totalValue, count(*) totalOrder,P.name FROM TB_ORDER O LEFT JOIN TB_PRODUCT P ON P.ID = O.PRODUCT_ID GROUP BY O.PRODUCT_ID")
    List<DashboardDTO> findDashboard();

    @Query(nativeQuery = true, value = "SELECT address as address, count(*) totalShow, sum(o.total) as totalValue, sum(o.quantity) as totalTickets, count(o.price) as totalOrder FROM TB_PRODUCT p left join tb_order o on o.product_id = p.id group by p.address order by 2 desc")
    List<DashboardAddressDTO> findDashboardAddress();

}
