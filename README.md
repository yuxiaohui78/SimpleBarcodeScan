# SimpleBarcodeScan
This code is based on https://github.com/zxing/zxing

#How to use it:

In gradle:
```
repositories {
	maven { url = 'https://jitpack.io' }
}
dependencies {
	compile 'com.github.yuxiaohui78:SimpleBarcodeScan:1.1'
}
```

In Android code:
```
public static final int BARCODE_REQ_ID = 0X100;

@Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnBarcodeScan){
            Intent i = new Intent(this, CaptureActivity.class);
            startActivityForResult(i, BARCODE_REQ_ID);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == BARCODE_REQ_ID && resultCode == Activity.RESULT_OK) {
            String barcode = data.getStringExtra("BarcodeNumber");
            TextView tvBarcodeResult = (TextView) findViewById(R.id.tvBarcodeResult);
            tvBarcodeResult.setText(barcode);
        }
    }
```
