package com.kapcb.framework.common.mapper;

import java.util.List;

/**
 * <a>Title: ModelMapper </a>
 * <a>Author: Kapcb <a>
 * <a>Description: ModelMapper <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/11/20 13:26
 */
public interface ModelMapper<D, P, V> {

    /**
     * convert dto to po
     *
     * @param dto D
     * @return P
     */
    P toModelPO(D dto);

    /**
     * convert po to dto
     *
     * @param po P
     * @return D
     */
    D toModelDTO(P po);

    /**
     * convert po to vo
     *
     * @param po P
     * @return V
     */
    V toModelVO(P po);

    /**
     * convert to po list
     *
     * @param dtoList List<D>
     * @return List<P>
     */
    List<P> toModelPOList(List<D> dtoList);

    /**
     * convert to dto list
     *
     * @param poList List<P>
     * @return List<D>
     */
    List<D> toModelDTOList(List<P> poList);

    /**
     * convert to vo list
     *
     * @param poList List
     * @return List<V>
     */
    List<V> toModelVOList(List<P> poList);
}
