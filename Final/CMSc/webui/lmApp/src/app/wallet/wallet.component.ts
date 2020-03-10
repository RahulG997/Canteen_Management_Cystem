import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Wallet } from '../wallet';
import { WalletService } from '../wallet.service';


@Component({
  selector: 'app-wallet',
  templateUrl: './wallet.component.html',
  styleUrls: ['./wallet.component.css']
})
export class WalletComponent implements OnInit {

  custId : number;
  amount : number;
  wallet : Observable<Wallet[]>
  wallet1 : Observable<Wallet[]>
  wallId : number;
  show() {
    this.walletService.addMoney(this.amount, this.custId).subscribe(x => {
      alert(x);
    })
  }

  constructor(private walletService : WalletService) { 
    this.wallet=walletService.showWallet();
    this.wallet1=walletService.showByWalletCustomerId(this.wallId);
  }

  ngOnInit() {
  }
}
