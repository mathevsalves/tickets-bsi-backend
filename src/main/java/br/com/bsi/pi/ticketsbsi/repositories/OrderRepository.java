package br.com.bsi.pi.ticketsbsi.repositories;

import br.com.bsi.pi.ticketsbsi.entities.Order;
import br.com.bsi.pi.ticketsbsi.entities.dto.DashboardAddressDTO;
import br.com.bsi.pi.ticketsbsi.entities.dto.DashboardDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(nativeQuery = true, value = "SELECT PRODUCT_ID AS productId , P.ADDRESS AS address , P.date_show AS dateShow , SUM(O.QUANTITY) AS totalTickets , SUM(O.TOTAL) AS totalValue , COUNT(*) totalOrder , P.name FROM TB_ORDER O LEFT JOIN tb_product P ON P.ID = O.PRODUCT_ID GROUP BY O.PRODUCT_ID, P.ADDRESS, P.date_show, P.name")
    List<DashboardDTO> findDashboard();

    @Query(nativeQuery = true, value = "SELECT address AS address, COUNT(*) totalShow, SUM(o.total) AS totalValue, SUM(o.quantity) AS totalTickets, COUNT(o.price) AS totalOrder FROM TB_PRODUCT p LEFT JOIN tb_order o ON o.product_id = p.id GROUP BY p.address ORDER BY 2 DESC")
    List<DashboardAddressDTO> findDashboardAddress();

}
