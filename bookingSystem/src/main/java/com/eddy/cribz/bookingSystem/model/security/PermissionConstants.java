package com.eddy.cribz.bookingSystem.model.security;



 
public final class PermissionConstants {

   
    /**
     * default constructor (Note: it is private because this class can't be
     * instantiated)
     */
    private PermissionConstants() {

    }

    @PermissionAnnotation(id = "A0A08826-96C0-438b-876E-55534ABE0461",
            description = "Ability to view user")
    public static final String PERM_VIEW_USER = "perm_view_user";

    @PermissionAnnotation(id = "CEC2B41D-841C-4FED-9A63-04E5649F8D22",
            description = "Ability to add or update users")
    public static final String PERM_SAVE_USER = "perm_save_user";

    @PermissionAnnotation(id = "8233207F-921A-413c-9492-81651B0C024D",
            description = "Ability to delete users")
    public static final String PERM_DELETE_USER = "perm_delete_user";

    @PermissionAnnotation(id = "4E77BDD1-2EAC-40BE-9A91-5CAF9CF6CFEC", description = "Ability to add users")
    public static final String PERM_ADD_USER = "perm_add_user";

    @PermissionAnnotation(id = "A3DBF242-F761-42E9-AC7C-9D2EFC716B44",
            description = "Ability to add or update a role")
    public static final String PERM_SAVE_ROLE = "perm_save_role";

    @PermissionAnnotation(id = "0C93831C-1667-49C0-8909-233424CA73B8",
            description = "Ability to delete a role")
    public static final String PERM_DELETE_ROLE = "perm_delete_role";

    @PermissionAnnotation(id = "FE446BB1-E8F8-40F4-9FAB-65FDD8C6183D",
            description = "Ability to add roles")
    public static final String PERM_ADD_ROLE = "perm_add_role";

    @PermissionAnnotation(id = "9FD9EAD9-C9E0-4885-B357-51504FD10D16",
            description = "Ability to view roles")
    public static final String PERM_VIEW_ROLE = "perm_view_role";

    @PermissionAnnotation(
            id = "BE77AA9B-60CC-47F7-B163-12B0064BE0FA",
            description = "Ability to access web resources if api is used in a web application")
    public static final String PERM_WEB_ACCESS = "perm_web_access";

    @PermissionAnnotation(id = "12078A16-C74D-4f83-BF2E-A4B6A50824FB",
            description = "Ability to view the administration control panel ")
    public static final String PERM_VIEW_ADMINISTRATION = "perm_view_administration";

    @PermissionAnnotation(id = "4ED96336-2928-4b51-9E57-5CD797F2C9DB",
            description = "Ability to edit/save/delete users")
    public static final String PERM_EDIT_USERS = "perm_edit_users";

    @PermissionAnnotation(id = "1043B4BB-2BC5-46e2-A8B9-A978B6B1AA98",
            description = "Ability to edit/save/delete roles")
    public static final String PERM_EDIT_ROLES = "perm_edit_roles";

   
    
   
}