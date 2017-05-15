package pl.lukaszpelczar.cracowguide;

/**
 * {@link Item} represents a item that should be shown in the list.
 */
public class Item {

    private static final int NO_IMAGE_PROVIDED = -1;
    private int mEnglishTranslationId;
    private int mPolishTranslationId;
    private int mAudioResourceId;
    private int mHotelNameId;
    private int mHotelDescriptionId;
    private int mHotelImageResourceId = NO_IMAGE_PROVIDED;
    private int mHotelLocationId;
    private int mHotelTypeId;
    private int mNightlifeNameId;
    private int mNightlifeAddressId;
    private int mNightlifeDescriptionId;
    private int mNightlifeTagsId;
    private int mNightlifeTypeId;
    private int mNightlifeImageResourceId = NO_IMAGE_PROVIDED;
    private int mEssentialsNameId;
    private int mEssentialsDescriptionId;
    private int mEssentialsTypeId;
    private int mEssentialsImageResourceId = NO_IMAGE_PROVIDED;
    private String mEssentialsUrl;
    private String mNightlifeUrl;
    private String mHotelUrl;

    //Constructor for Phrases Fragment.
    public Item(int englishTranslationId, int polishTranslationId, int audioResourceId) {
        mEnglishTranslationId = englishTranslationId;
        mPolishTranslationId = polishTranslationId;
        mAudioResourceId = audioResourceId;
    }

    //Constructor for Hotel Fragment.
    public Item(int hotelNameId, int hotelDescriptionId, int hotelImageResourceId,
                int hotelLocationId, int hotelTypeId, String hotelUrl) {
        mHotelNameId = hotelNameId;
        mHotelDescriptionId = hotelDescriptionId;
        mHotelImageResourceId = hotelImageResourceId;
        mHotelLocationId = hotelLocationId;
        mHotelTypeId = hotelTypeId;
        mHotelUrl = hotelUrl;
    }

    //Constructor for Nightlife fragment.
    public Item(int nightlifeNameId, int nightlifeAddressId, int nightlifeDescriptionId,
                int nightlifeTagsId, int nightlifeTypeId, int nightlifeImageResourceId,
                String nightlifeUrl) {
        mNightlifeNameId = nightlifeNameId;
        mNightlifeAddressId = nightlifeAddressId;
        mNightlifeDescriptionId = nightlifeDescriptionId;
        mNightlifeTagsId = nightlifeTagsId;
        mNightlifeTypeId = nightlifeTypeId;
        mNightlifeImageResourceId = nightlifeImageResourceId;
        mNightlifeUrl = nightlifeUrl;
    }

    //Constructor for Essentials fragment.
    public Item(int essentialsNameId, int essentialsDescriptionId, int essentialsTypeId,
                int essentialsImageResourceId, String essentialsUrl){
        mEssentialsNameId = essentialsNameId;
        mEssentialsDescriptionId = essentialsDescriptionId;
        mEssentialsTypeId = essentialsTypeId;
        mEssentialsImageResourceId = essentialsImageResourceId;
        mEssentialsUrl = essentialsUrl;
    }

    public int getEnglishTranslationId() {
        return mEnglishTranslationId;
    }

    public int getPolishTranslationId() {
        return mPolishTranslationId;
    }

    public int getAudioResourceId() {
        return mAudioResourceId;
    }

    public int getHotelImageResourceId() {
        return mHotelImageResourceId;
    }

    public boolean hotelHasImage() {
        return mHotelImageResourceId != NO_IMAGE_PROVIDED;
    }

    public int getHotelNameId() {
        return mHotelNameId;
    }

    public int getHotelDescriptionId() {
        return mHotelDescriptionId;
    }

    public int getHotelLocationId() {
        return mHotelLocationId;
    }

    public int getHotelTypeId() {
        return mHotelTypeId;
    }

    public int getNightlifeNameId() {
        return mNightlifeNameId;
    }

    public int getNightlifeAddressId() {
        return mNightlifeAddressId;
    }

    public int getNightlifeDescriptionId() {
        return mNightlifeDescriptionId;
    }

    public int getNightlifeTagsId() {
        return mNightlifeTagsId;
    }

    public int getNightlifeTypeId() {
        return mNightlifeTypeId;
    }

    public int getNightlifeImageResourceId() {
        return mNightlifeImageResourceId;
    }

    public boolean nightlifeHasImage() {
        return mNightlifeImageResourceId != NO_IMAGE_PROVIDED;
    }

    public int getEssentialsNameId() {
        return mEssentialsNameId;
    }

    public int getEssentialsDescriptionId() {
        return mEssentialsDescriptionId;
    }

    public int getEssentialsTypeId() {
        return mEssentialsTypeId;
    }

    public int getEssentialsImageResourceId() {
        return mEssentialsImageResourceId;
    }

    public boolean essentialsHasImage() {
        return mEssentialsImageResourceId != NO_IMAGE_PROVIDED;
    }

    public String getEssentialsUrl() {
        return mEssentialsUrl;
    }

    public String getNightlifeUrl() {
        return mNightlifeUrl;
    }

    public String getHotelUrl() {
        return mHotelUrl;
    }
}
