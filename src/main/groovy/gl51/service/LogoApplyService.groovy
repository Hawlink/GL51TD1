package gl51.service

import gl51.data.Photo

/**
 * Ceci permet d'appliquer un logo en filigrane
 */
interface LogoApplyService {

    /**
     * Applique le logo sur une image
     * @return
     */
    Photo applyLogo(int id)
}
