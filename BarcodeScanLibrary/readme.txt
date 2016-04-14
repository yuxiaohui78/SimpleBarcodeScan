How to use it.
1. Call the Barcode scan Activity.
   Intent intent = new Intent(this.getActivity(), CaptureActivity.class);
   startActivityForResult(intent, BARCODE_SCAN_ACTIVITY_REQUEST);
   
2. Get the barcode in onActivityResult.
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == BARCODE_SCAN_ACTIVITY_REQUEST && resultCode == CaptureActivity.RESULT_OK){
            String barcode = data.getStringExtra("BarcodeNumber");
            edtCaseNumber.setText(barcode);
        }
    }
