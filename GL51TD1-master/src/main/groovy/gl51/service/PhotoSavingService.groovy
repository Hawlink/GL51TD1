package gl51.service

import gl51.data.Photo

/**
 * Ceci permet de sauvegarder une photo sur le cloud
 */
interface PhotoSavingService {

    /**
     * Sauvegarde une photo
     * @return
     */
    void savePhoto(int id)
}
