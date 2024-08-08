# Beluga Serverprint Configuration
## Menu: Print Configuration
### Tab: Print configuration
No fields here are used in logic, they are only identifiers.
### Tab: Print configuration entry
#### Name & Description
These fields are not used in any logic.
#### User/Contact
This is the user this configuration belongs to.
#### Printer
This is the printer to be used.
#### Printer Config
This is the Printer Configuration to be used.
#### IsStandardPrintConfig
If no user-specific configuration can be found, this is valid to be used.

---
## Menu: Printer Provider
#### Search key, Name, Description & Comment/Help
These fields are not used in any logic.
#### printer URI
The URI of the print server.
#### printer username & printer password
The credentials for this print server, should it require them.
#### Protocol
A technical key.  
When trying to address a printer, the process will look for other plugins implementing printer lookup, attribute lookup and printing.
The implementation is selected using this key.
#### Process: Serverprint Printer Lookup
Query the printer provider for its existing printers.  
This will create entries under the *Printer* Menu entry.

---
## Menu: Print Profile
### Tab: Print Profile
A print profile may be marked as default, or added to a User (the sender) or Business Partner (the recipient).
#### Search key, Name & Description
These fields are not used in any logic.
#### Priority
Higher priority print profiles are chosen when multiple are valid.  
If a print profile is only valid because it is default, it has *naturally lower* priority.
#### Default
Whether this print profile is supposed to be valid for everyone.

### Tab: Subprofile
The sub profile groups *Copies* by when they are supposed to be executed.
#### Name & Description
These fields are not used in any logic.
#### Doc Type
If this document type is being processed by Beluga Serverprint, copies belonging to this sub profile will be executed.
#### Tab
If Beluga Serverprint is being called from the given Tab, copies belonging to this sub profile will be executed.

### Tab: Copy
Copies hold more detailed instructions which processes should be performed.
#### Name & Description
These fields are not used in any logic.
#### Process
This may be any report or process that returns a file.  
Jasper Reports will appear at the top.
#### File Extension
This is given to the process to determine file format.  
It is also added to the end of the file name.
#### Report Variant
This is given to the process to determine variants.
#### Export File Name Pattern
A pattern accepting @\<placeholder\>@.  
This pattern also allows a special @$\<placeholder\>@ variant, where \<placeholder\> is replaced by the field with the same name in the record being processed.
#### Copy Type
???
#### Print Option
When copies with multiple print options are valid, the executing user chooses one of them. Only copies of that or no print option are executed.  
When copies with multiple print options are valid, but those print options are "process only", the user will not be prompted.
#### To Archive
The file will be archived within iDempiere in the record's archive.
#### Use document from archive
This option will appear if *To Archive* is ticked.  
If a document with a given file extension exists in the record's archive already, the newest of them is loaded rather than running the report/process.
#### Printconfig
The print configuration to be used. If this is empty, nothing will be printed.
#### Copies
The amount of copies to be printed.
#### Send mail to User/Contact
????
#### senddirectly
Send mail immediately and silently, without opening a dialog for the currently logged in user.
#### mail to fixed address
Send the mail exclusively to the fixed address given in *To EMail*.
#### Mail Template
The mail template to be used when sending mail.
#### To EMail
This option will appear if *mail to fixed address* is ticked.  
This specifies the recipient mail address.
#### use actual user as From:
Use the currently logged in iDempiere user as the mail's sender.
#### User to be used as From:
This option wil disappear when *use actual user as From:* is ticked.  
Specify a static user to serve as the mail's sender.
#### To EMails (CC)
A comma-separated list of mail addresses to be added as CC.
#### Bcc
A comma-separated list of mail addresses to be added as BCC.
#### E-Mail Attachment Prefixes
A comma-separated list of text strings.  
If the record has attachments, and those attachments' names begin with any of these strings, they will be added to the mail as attachments.
#### DepositPath
A file path to a directory on the server. The file will be saved there.

---
## Menu: Printer
### Tab: Printer
#### Search Key, Name & Description
These fields are not used in any logic.
#### Printer Name
The identifier of a given printer, used to find a specific printer at a print server.
#### printer URI
Required to reach a printer directly.  
When using a print server, use a *printer provider*.
#### printer username & printer password
When addressing a printer that requires credentials directly,
enter the credentials here.  
When using a print server, use a *printer provider*.
#### Printer Provider
If you don't want to address the printer directly but as part of a print server, use a printer provider.
#### Process: Lookup Printerattributes
This process fills the tabs *Printer Attributes* and *Printer Attribute Values*.
### Tab: Configuration
No fields here are used in logic, they are only identifiers.
### Tab: Attributes
#### Printer attributename
An attribute this printer allows to be specified.
#### Attributevalue
Choose a value for the given attribute. These are requested from the printer (or its definition) and should be valid.
#### Printer Attribute Value
If no given value is chosen, a value may be given manually.
### Tab: Printer Attributes
#### Name & Description
These fields are not used in any logic.
#### Printer Attribute Name
An attribute which is supported by the printer, which may be added to the print job.
### Tab: Printer Attribute Values
#### Name & Description
These fields are not used in any logic.
#### Printer Attribute Value
A value that is allowed for a given attribute.

---
## Menu: Copy Type
???

---
## Menu: Print Option
### Tab: Print Option
#### Search Key, Name & Description
These fields are not used in any logic.
#### Is limited to process calls
If ticked, this option is not valid to be chosen by user interaction. It can only be passed to Beluga Serverprint by process call or in scripts.
### Tab: Print Option Trl
Includes translations for your print option in case of multi language tenants and organizations.

---
# Technical Features
## Process parameters
All process parameters given to the Beluga Serverprint call will be passed to the report/process call.

