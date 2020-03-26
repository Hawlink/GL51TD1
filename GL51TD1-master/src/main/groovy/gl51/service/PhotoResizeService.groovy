package gl51.service

import gl51.data.Photo

/**
 * Ceci permet de redimensionner des photos
 */
interface PhotoResizeService {

    /**
     * Redimensionne une photo
     * @return
     */
    Photo resizePhoto(int id)
}
